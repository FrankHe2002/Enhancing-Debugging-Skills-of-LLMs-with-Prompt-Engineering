import bug_gen
import os, random

# Get all algorithm problems. The folder "../solutions_correct/algorithms" contains folders of algorithm problems, classified by letter.
# For example, "../solutions_correct/algorithms/a" contains all problems that start with the letter "a"
# Each of those folders also contain folders, whose names are the problem names.
# For example, the problem "Baseball Game" is located at ../solutions_correct/algorithms/B/"Baseball Game"/"Baseball Game.java"

# First, we find a list of all problems.
letter_folders = os.listdir("..\\solutions_correct\\algorithms")
if ".DS_Store" in letter_folders:
    letter_folders.remove(".DS_Store")
if "README.md" in letter_folders:
    letter_folders.remove("README.md")
problem_files = []

# Then, we find a list of all problem files.
for letter in letter_folders:
    problem_folders = os.listdir("..\\solutions_correct\\algorithms\\" + letter)
    if ".DS_Store" in problem_folders:
        problem_folders.remove(".DS_Store")
    if "README.md" in problem_folders:
        problem_folders.remove("README.md")
    for problem in problem_folders:
        problem_files.append("..\\solutions_correct\\algorithms\\" + letter + "\\" + problem + "\\" + problem + ".java")

# Clear the output folder
for file in os.listdir("output"):
    os.remove("output\\" + file)

# Then, we pick 10 random problems and generate 5 buggy versions of each problem.
for i in range(10):
    # Pick a random problem
    problem = random.choice(problem_files)
    # Read file contents
    try:
        with open(problem, "r") as file:
            file_data = file.read()
    except:
        i -= 1
        problem_files.remove(problem)
        continue

    # Generate 5 buggy versions of the problem
    
    for j in range(5):
        # Generate bugs

        buggy = bug_gen.add_bugs(file_data, 1)
        # Write to file
        problem_name = problem.split("\\")[-1].split(".")[0]
        with open("output\\" + problem_name + "_bug_" + str(j) + ".java", "w") as file:
            file.write(buggy)
    print("Generated buggy version of " + problem_name)
    
    # Also write a correct version of the problem
    with open("output\\" + problem_name + "_correct.java", "w") as file:
        file.write(file_data)
    
    problem_files.remove(problem)