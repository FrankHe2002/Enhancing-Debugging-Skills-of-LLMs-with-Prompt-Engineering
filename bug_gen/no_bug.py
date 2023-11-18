# This script simply copies all Java files from a source directory to a target directory.

import os
import shutil
import glob

def copy_java_files(source_directory, target_directory):
    # Create the target directory if it doesn't exist
    if not os.path.exists(target_directory):
        os.makedirs(target_directory)

    # Iterate over all Java files in the source directory
    for file_path in glob.glob(os.path.join(source_directory, '*', '*', '*.java')):
        # Define the target file path
        target_file_path = os.path.join(target_directory, os.path.basename(file_path))

        # Copy the file to the target directory
        shutil.copy(file_path, target_file_path)
        print(f"Copied: {file_path} to {target_file_path}")

if __name__ == "__main__":
    source_dir = '../solutions_correct/algorithms'  # Replace with the actual source directory path
    target_dir = '../correct_codes'  # Target directory where Java files will be copied

    copy_java_files(source_dir, target_dir)
