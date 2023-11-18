import os
import subprocess

def evaluate_folders(folder1, folder2, suffix, evaluator_script, hyperparameters='0.25,0.25,0.25,0.25'):
    for filename in os.listdir(folder1):
        if filename.endswith('.java'):
            base_name = os.path.splitext(filename)[0]
            modified_file_name = f"{base_name}_{suffix}.java"
            modified_file_path = os.path.join(folder2, modified_file_name)

            if os.path.exists(modified_file_path):
                original_file_path = os.path.join(folder1, filename)

                # Constructing the command to call the evaluator script
                command = ['python', evaluator_script, '--pred', modified_file_path, '--actual', original_file_path, '--hyper', hyperparameters]
                subprocess.run(command)
            else:
                print(f"Matching file for {filename} not found in {folder2}")

if __name__ == '__main__':
    # Example usage
    folder1 = '../bug_gen/output'  # Path to the first folder (original files)
    folder2 = '../bug_gen/bugged_output'  # Path to the second folder (modified files)
    suffix = 'zeroshot'  # Suffix used in the modified files
    evaluator_script = '../evaluator/evaluation.py'  # Path to evaluator script
    evaluate_folders(folder1, folder2, suffix, evaluator_script)
