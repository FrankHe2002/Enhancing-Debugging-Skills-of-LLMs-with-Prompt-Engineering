# This script is used to generate bugs for all Java files in a source directory.

import os
import glob
from bug_gen import bug_gen  # Replace 'your_bug_gen_module' with the actual name of your module

def generate_bugs_for_all_files(source_directory, target_directory, num_bugs=1):
    # Create the target directory if it doesn't exist
    if not os.path.exists(target_directory):
        os.makedirs(target_directory)

    # Iterate over all Java files in the source directory
    for file_path in glob.glob(os.path.join(source_directory, '*', '*', '*.java')):
        base_name = os.path.basename(file_path)
        output_path = os.path.join(target_directory, base_name)

        # Prepare arguments and generate the bug
        kwargs = {'in': file_path, 'out': output_path, 'num': num_bugs}
        bug_gen(**kwargs)

if __name__ == "__main__":
    source_dir = '../solutions_correct/algorithms'  # Source directory
    target_dir = '../bug_gen/bug_codes'  # Target directory where bugged files will be saved

    generate_bugs_for_all_files(source_dir, target_dir, num_bugs=1)
