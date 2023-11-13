import pickle
import bs4

# The goal of this code is to extract the example data from the question body
#   using BS4 and store it in a csv.


def is_valid_expression(exp):
    # Given a string, make sure it's a valid python expression. Specifically,
    #   it should have the form ?? = ??, where ?? is some value (list, int, etc.)
    # First, make sure there's only one equals sign
    exp = exp.replace("true", "True").replace("false", "False")

    if exp.count("=") > 1:
        return False
    # Now make sure the right side is a valid expression
    right_side = exp.split("=")[1].strip() if exp.count("=") == 1 else exp
    try:
        eval(right_side)
    except:
        return False
    
    return True
    


# Replace "filename.pickle" with the actual filename of your .pickle file
with open("data/questionBody.pickle", "rb") as f:
    data = pickle.load(f)

valid, invalid = 0, 0
ex = []

for d in data:
    ex.append([])
    question_body = d.Body
    # Examples are always wrapped in <strong class=\"example\">...</strong> tags.
    #   We can use BS4 to extract the example data.
    soup = bs4.BeautifulSoup(question_body, "html.parser")
    examples = soup.find_all("strong", {"class": "example"})
    #print(examples)
    if len(examples) == 0:
        invalid += 1
        continue
    # TODO Some questions have examples but are missing the example tag. We may want to add a check for this later.
    
    # Check if the parent is <p>; if yes, we technically need to go up one more level.
    for i in range(len(examples)):
        if examples[i].parent.name == "p":
            examples[i] = examples[i].parent
        else:
            # After inspection, questions with no <p> parent are all bad anyway.
            invalid += 1
            break
    
    # The next sibling (find_next_sibling) is a pre tag, which always contains
    #   a <strong>Input</strong> and <strong>Output</strong> tag.
    ex_are_valid = True
    for example in examples:
        if ex_are_valid == False:
            break
            
        pre = example.find_next_sibling()
        if pre is None or pre.name != "pre":
            ex_are_valid = False
            break
        # The inside of the <pre> tag has the form 
        """
        <pre>
        <strong>Input</strong>
        [...]
        <strong>Output</strong>
        [...]

        <strong>Explanation</strong>
        ...
        </pre>
        """
        
        # Find a strong tag that contains the text "Input" or "Input:" to start
        input_tag = pre.find("strong", string=lambda s: s and "Input" in s)
        if input_tag is None:
            ex_are_valid = False
            break
        
        # Find a strong tag that contains the text "Output" or "Output:"
        output_tag = pre.find("strong", string=lambda s: s and "Output" in s)
        if output_tag is None:
            ex_are_valid = False
            break

        # Find the next strong tag after the output tag
        explanation_tag = output_tag.find_next_sibling("strong")

        # The input data could be in multiple tags, so look through neighbors until we find output
        input_tag = input_tag.next_sibling
        input_data = []
        while input_tag != output_tag:
            input_data.append(input_tag.text.strip())
            input_tag = input_tag.next_sibling
            if input_tag is None:
                ex_are_valid = False
                break
        
        # The output data is the text between the output tag and the explanation tag. Problem:
        # explanation_tag is None if there is no explanation, and in that case we go until the end.
        output_data = []
        output_tag = output_tag.next_sibling
        while output_tag != explanation_tag or (explanation_tag is None and output_tag is not None):
            output_data.append(output_tag.text.strip())
            output_tag = output_tag.next_sibling
            if output_tag is None:
                break
        # Make sure input and output are valid expressions
        if not is_valid_expression("".join(input_data)) or not is_valid_expression("".join(output_data)):
            ex_are_valid = False
            """
            print(input_data)
            print(output_data)
            print(is_valid_expression("".join(input_data)), is_valid_expression("".join(output_data)), "\n\n")
            """
            break

        # Save into ex
        ex[-1].append((input_data, output_data))
    
    if ex_are_valid:
        valid += 1
    else:
        invalid += 1
    


for question in ex:
    for example in question:
        # Count number of = in input
        input_equals = 0
        for line in example[0]:
            input_equals += line.count("=")
        
        if input_equals == 1:
            print("Input:", example[0])
            print("Output:", example[1])


print("Valid:", valid)
print("Invalid:", invalid)
print(len(ex), len(data), valid + invalid)