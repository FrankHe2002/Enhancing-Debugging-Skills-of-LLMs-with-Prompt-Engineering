import subprocess
import sys

def calculate_codebleu(ref_dir, hyp_dir):
    evaluator_path = "CodeXGLUE/Code-Code/code-to-code-trans/evaluator/evaluator.py"
    command = f"python {evaluator_path} -ref {ref_dir} -pre {hyp_dir}"
    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
    out, err = process.communicate()
    
    print(out.decode("utf-8"))

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python eval.py <path-to-reference-code> <path-to-hypothesis-code>")
        sys.exit(1)
    ref_dir = sys.argv[1]
    hyp_dir = sys.argv[2]
    calculate_codebleu(ref_dir, hyp_dir)
