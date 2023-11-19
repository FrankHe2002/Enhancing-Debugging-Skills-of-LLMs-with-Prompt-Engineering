import pyautogui
import time
import pyperclip
from bs4 import BeautifulSoup

# Notes: Open inspect-element, switch to dynamic layout, switch to Java

TEXT_INPUT = (1340, 680)
CONSOLE = (2200, 1500)
OUTPUT_COPY_LOCATION = (2200, 1430)
OUTPUT_COPY_BUTTON = (OUTPUT_COPY_LOCATION[0] + 40, OUTPUT_COPY_LOCATION[1] - 145)
URL_BAR = (860, 80)
EXTRACTION_JS = """var tmp = {"contents": document.querySelector("#qd-content > div > div:nth-last-child(6)").innerHTML};tmp"""


def contains_testcases_passed(tag):
    if tag.name != "div":
        return False
    for child in tag.children:
        if (not child.name is None) and "testcases passed" in child.text:
            return False
        
    return "testcases passed" in tag.text

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


def run_code(problem_id, code):
    # Open the problem
    url = f"https://leetcode.com/problems/{problem_id}/"
    pyautogui.click(860, 80)
    pyautogui.typewrite(url)
    pyautogui.press('enter')
    time.sleep(4)

    # Click on the main text input
    pyautogui.click(TEXT_INPUT)
    time.sleep(0.05)

    # Clear the text input and copy-paste the code
    pyautogui.hotkey('ctrl', 'a')
    pyperclip.copy(code)
    pyautogui.hotkey('ctrl', 'v')

    # Run with Ctrl+Enter
    pyautogui.hotkey('ctrl', 'enter')

    # Click on console
    pyautogui.click(CONSOLE)

    # Spam console with nonsense so we know we're at the bottom
    for i in range(15):
        pyautogui.typewrite("nonsense__aa")
        pyautogui.press('enter')

    # Now we wait for the code submission to finish running, by looking for a picture?
    time.sleep(5)

    # Run the extraction code
    pyautogui.typewrite(EXTRACTION_JS)
    pyautogui.press('enter')
    time.sleep(0.25)

    # Scroll to the bottom
    pyautogui.scroll(-10000)
    time.sleep(0.05)

    # Copy the output by right-clicking the output location and clicking copy
    pyautogui.rightClick(OUTPUT_COPY_LOCATION)
    time.sleep(0.05)
    pyautogui.moveTo(OUTPUT_COPY_BUTTON)
    time.sleep(0.05)
    pyautogui.click(OUTPUT_COPY_BUTTON)
    time.sleep(0.05)

    # Extract the output from the clipboard using tkinter
    output = pyperclip.paste()
    # output is a json object with the results in "contents"; convert to dict
    output = eval(output)["contents"]

    # AC doesn't have any score, so we can just check for that
    if "<span data-e2e-locator=\"submission-result\">Accepted</span>" in output:
        return 1, 1, "Accepted"
    
    # Grab the results and return
    bs = BeautifulSoup(output, "html.parser")

    # Returns (passed, total cases, message)
    return get_result(bs)
