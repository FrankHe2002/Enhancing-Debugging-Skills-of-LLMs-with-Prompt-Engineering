"""
Introduces bugs to Java code in a file, provided through kwargs
"""
import bugs, random, os

def add_bugs(file_data, num_bugs, log=False):
    bug_types = [bugs.ArrayIndexBug, bugs.IncorrectConditionBug, bugs.IncorrectOperationBug, bugs.IncorrectValueBug, bugs.MissingCharacterBug]

    for i in range(num_bugs):
        # Get a random bug
        bug = random.choice(bug_types)()
        # Create and apply bug
        file_data = bug.effect(file_data)
        if log and bug.valid:
            print(f"Bug {i+1}: {bug.name} ({bug.valid}): {bug.state}")

    return file_data


def bug_gen(**kwargs):
    """
    Introduces bugs to Java code in a file, provided through kwargs
    """
    # Get the file path from kwargs
    file_path = kwargs.get("in", "")
    # Get the number of bugs to introduce from kwargs
    num_bugs = kwargs.get("num", 1)
    # Get output path
    output_path = kwargs.get("out", "")
    # Get log
    log = kwargs.get("log", False)

    if len(file_path) == 0:
        raise ValueError("Input file path not provided")
    if len(output_path) == 0:
        raise ValueError("Output file path not provided")
    if num_bugs < 0:
        raise ValueError("Number of bugs must be greater than 0")

    # Add .java to file paths if not already there
    if not ".java" in file_path.lower()[-5:]:
        file_path += ".java"
    if not ".java" in output_path.lower()[-5:]:
        output_path += ".java"
    
    print(f"Input file path: {file_path}")
    print(f"Output file path: {output_path}")

    
    # Check to make sure paths exist
    if not os.path.exists(file_path):
        raise ValueError("Input file path does not exist")

    # Open and read file
    with open(file_path, "r") as file:
        file_data = file.read()
    
    # Add bugs
    file_data = add_bugs(file_data, num_bugs, log=log)
    
    # Write to output file
    with open(output_path, "w") as file:
        file.write(file_data)

if __name__ == "__main__":
    import argparse

    # Create parser
    parser = argparse.ArgumentParser(description="Introduces bugs to Java code in a file, provided through kwargs")
    # Add arguments
    parser.add_argument("-i", "--in", type=str, help="The input file path")
    parser.add_argument("-o", "--out", type=str, help="The output file path")
    parser.add_argument("-n", "--num", type=int, help="The number of bugs to introduce")
    parser.add_argument("-l", "--log", type=bool, help="Whether to log the bugs introduced")
    # Parse arguments
    args = parser.parse_args()

    # Run bug_gen
    bug_gen(**vars(args))