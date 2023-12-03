import pyautogui
import time
import pyperclip
from bs4 import BeautifulSoup
import pandas as pd
from tqdm import tqdm
import os
import random
import json
# Notes: Open inspect-element, switch to dynamic layout, switch to Java

TEXT_INPUT = (1340, 680)
CONSOLE = (2200, 1500)
OUTPUT_COPY_LOCATION = (2200, 1430)
URL_BAR = (860, 80)

OUTPUT_COPY_BUTTON = (OUTPUT_COPY_LOCATION[0] + 40, OUTPUT_COPY_LOCATION[1] - 145)
EXTRACTION_JS = """var tmp = {"contents": document.querySelector("#qd-content > div > div:nth-last-child(6)").innerHTML};tmp"""

def problem_name_to_id(pname):
    # Read from questions.csv
    df = pd.read_csv('questions.csv')
    # Find the row with the problem name
    print(pname)
    j = df[df['title'] == pname].index[0]
    # Return the problem id
    return df['titleSlug'][j]

def contains_testcases_passed(tag):
    if tag.name != "div":
        return False
    for child in tag.children:
        if (not child.name is None) and "testcases passed" in child.text:
            return False
        
    return "testcases passed" in tag.text

def reconstruct_path(bug_path):
    # The file names of the buggy paths are of the form <problem name>_<bug type>.java but the
    # file names of the fixed paths are of the form <problem name>.java, so we need to reconstruct
    # the fixed path from the buggy path. Split the path by '_' and then join everything except
    # the last element.
    if "no_bug" in bug_path:
        bug_path = bug_path.replace("no_bug", "nobug")
    return '_'.join(bug_path.split('_')[:-1]) + '.java'

def get_result(bs):
    # Look for the div with "testcases passed" in it
    score, max_score, message = 0, 0, ""
    target_div = bs.find(contains_testcases_passed)
    # Grab the span inside the div
    span = target_div.find("span")
    # Grab the score inside the span
    text = span.text.split(" / ")
    score, max_score = int(text[0].strip()), int(text[1].strip())

    # Now move up two divs and grab the text; the message seems to move around a lot
    txt = target_div.parent.parent.text
    message = txt.replace(span.text, "").replace("testcases passed", "").replace("Editorial", "").strip()

    return score, max_score, message


def score_leetcode(problem_id, code, enter_url=True):
    # Open the problem
    if enter_url:
        url = f"https://leetcode.com/problems/{problem_id}/"
        pyautogui.click(860, 80)
        pyautogui.typewrite(url)
        pyautogui.press('enter')
        time.sleep(4)

    # Click on the main text input
    pyautogui.click(TEXT_INPUT)
    time.sleep(0.02)

    # Clear the text input and copy-paste the code
    pyautogui.hotkey('ctrl', 'a')
    pyperclip.copy(code)
    pyautogui.hotkey('ctrl', 'v')
    time.sleep(0.02)

    # Run with Ctrl+Enter
    pyautogui.hotkey('ctrl', 'enter')

    # Click on console
    pyautogui.click(CONSOLE)

    # Spam console with nonsense so we know we're at the bottom
    for i in range(20):
        pyautogui.typewrite("nonsense__aa")
        pyautogui.press('enter')

    # Now we wait for the code submission to finish running, by looking for a picture?
    time.sleep(1)

    # Run the extraction code
    pyautogui.typewrite(EXTRACTION_JS)
    pyautogui.press('enter')
    time.sleep(1)

    # Scroll to the bottom
    pyautogui.scroll(-10000)
    time.sleep(0.1)

    # Copy the output by right-clicking the output location and clicking copy
    pyautogui.rightClick(OUTPUT_COPY_LOCATION)
    time.sleep(0.05)
    pyautogui.moveTo(OUTPUT_COPY_BUTTON)
    time.sleep(0.02)
    pyautogui.click(OUTPUT_COPY_BUTTON)
    time.sleep(0.05)

    # Extract the output from the clipboard using tkinter
    output = pyperclip.paste()
    # output is a json object with the results in "contents"; convert to dict using json library
    output = json.loads(output)['contents']

    # AC doesn't have any score, so we can just check for that
    if "<span data-e2e-locator=\"submission-result\">Accepted</span>" in output:
        return 1, 1, "Accepted"
    
    # Grab the results and return
    bs = BeautifulSoup(output, "html.parser")

    # Returns (passed, total cases, message)
    return get_result(bs)


def evaluate_folders(folder_correct, folder_bug, folder_debugged, output_name="", num_files=100, set_list=[]):
    df = pd.DataFrame(columns=['problem_name', 'bug_path', 'correct_path', 'debugged_path', 'bug_type', 'test_case_total', 'score_bug', 'score_debugged', 'message_bug', 'message_debugged', 'difference'])
    #df = pd.read_csv(f'leetcode_evals_{output_name}.csv', index_col=False)
    rows = []
    
    if len(set_list) == 0:
        # Shuffle and pick num_files random to do
        files = list(os.listdir(folder_debugged))
        files.sort()
        random.seed(10)
        random.shuffle(files)
        files = files[:num_files]
    else:
        files = set_list
    files.sort()


    for filename in tqdm(files):

        if len(df) > num_files:
            break
        if '_'.join(filename.split('_')[:-1]) in df['problem_name'].values:
            continue
        if filename.endswith('.java'):
            try:
                row = {}
                # Get the problem name, which may include underscores.
                row['problem_name'] = ['_'.join(filename.split('_')[:-1])]
                row['bug_path'] = [os.path.join(folder_bug, filename)]
                row['correct_path'] = [os.path.join(folder_correct, reconstruct_path(filename))]
                row['debugged_path'] = [os.path.join(folder_debugged, filename)]
                row['bug_type'] = [filename.split('_')[-1][:-5]]
                # Read the files
                with open(row['bug_path'][0], 'r') as f:
                    rbp = f.read()
                with open(row['correct_path'][0], 'r') as f:
                    rcp = f.read()
                with open(row['debugged_path'][0], 'r') as f:
                    rdp = f.read()
                # Find last occurrence of string ```java in rdp and remove everything before that
                rdp = rdp.replace("``` java", "```java")
                if "```java" in rdp:
                    rdp = rdp[rdp.rindex("```java") + 7:]
                # Find last occurrence of string ``` in rdp and remove everything after that
                if "```" in rdp:
                    rdp = rdp[:rdp.rindex("```")]
                
                score_bugged = score_leetcode(problem_name_to_id(row['problem_name'][0]), rbp)
                score_debugged = score_leetcode(problem_name_to_id(row['problem_name'][0]), rdp, enter_url=False)
                row['test_case_total'] = [max(score_bugged[1], score_debugged[1])]

                row['message_bug'] = [score_bugged[2]]
                row['message_debugged'] = [score_debugged[2]]
                if row['test_case_total'][0] != 0 and row["message_bug"][0] != "Accepted":
                    row['score_bug'] = [score_bugged[0] / row['test_case_total'][0]]
                else:
                    row['score_bug'] = [0]
                    
                if row['test_case_total'][0] != 0 and row["message_debugged"][0] != "Accepted":
                    row['score_debugged'] = [score_debugged[0] / row['test_case_total'][0]]
                else:
                    row['score_debugged'] = [0]
                    
                row['difference'] = [row['score_debugged'][0] - row['score_bug'][0]]
                rows.append(pd.DataFrame.from_dict(row))
            except:
                print(f"Error on {filename}")
    
        df = pd.concat([df] + rows, ignore_index=True)
        rows = []
        # Sort by problem name
        df = df.sort_values(by=['problem_name'])
        df.to_csv(f'leetcode_evals_{output_name}.csv', index=False)
    return df

def filter_files(folders):
    # Find file names that are in all folders
    files = []
    for folder in folders:
        files.append(set(os.listdir(folder)))
    files = set.intersection(*files)
    return list(files)

# Read files
def main():
    files = filter_files(["../../data/formatted/debugged_codes_0_n", "../../data/formatted/debugged_codes_0_c", "../../data/formatted/debugged_codes_f_n", "../../data/formatted/debugged_codes_f_c"])
    files.sort()
    random.seed(10)
    random.shuffle(files)
    files = files[:35]
    print(files)

    time.sleep(4)
    df = evaluate_folders('../../data/formatted/correct_codes', '../../data/formatted/buggy_codes', '../../data/formatted/debugged_codes_0_n', output_name="0_n", num_files=1)
    #df = evaluate_folders('../../data/formatted/correct_codes', '../../data/formatted/buggy_codes', '../../data/formatted/debugged_codes_0_c', output_name="0_c", num_files=1)
    #df = evaluate_folders('../../data/formatted/correct_codes', '../../data/formatted/buggy_codes', '../../data/formatted/debugged_codes_f_n', output_name="f_n", num_files=1)
    #df = evaluate_folders('../../data/formatted/correct_codes', '../../data/formatted/buggy_codes', '../../data/formatted/debugged_codes_f_c', output_name="f_c", num_files=1)
    print(df)

if __name__ == "__main__":
    main()