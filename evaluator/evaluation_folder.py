import os
import subprocess

def evaluate_folder(folder_path, evaluator_script, hyperparameters='0.25,0.25,0.25,0.25'):
    for filename in os.listdir(folder_path):
        if filename.endswith('_zeroshot.java'):
            base_name = filename[:-len('_zeroshot.java')]
            correct_file_name = base_name + '_correct.java'
            correct_file_path = os.path.join(folder_path, correct_file_name)

            if os.path.exists(correct_file_path):
                zeroshot_file_path = os.path.join(folder_path, filename)

                # Constructing the command to call the evaluator script
                command = ['python', evaluator_script, '--pred', zeroshot_file_path, '--actual', correct_file_path, '--hyper', hyperparameters]
                subprocess.run(command)
            else:
                print(f"Matching correct file not found for {filename}")

if __name__ == '__main__':
    # Example usage
    folder_path = '../bug_gen/output'  # Replace with the actual folder path
    evaluator_script = '../evaluator/evaluation.py'  # Replace with the path to evaluator script
    evaluate_folder(folder_path, evaluator_script)
