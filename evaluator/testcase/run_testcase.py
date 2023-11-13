import subprocess
import threading

def run_java_code(java_code, input_str=None):
    # Compile the java code
    compile_process = subprocess.Popen(['javac', '-'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    compile_process.stdin.write(java_code)
    compile_process.stdin.close()
    compile_process.wait()
    compile_output = compile_process.stderr.read()
    if compile_output:
        return compile_output

    # Run the java code
    run_process = subprocess.Popen(['java', 'Main'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    if input_str:
        run_process.stdin.write(input_str)
        run_process.stdin.close()

    # Set up a timer to interrupt the process if it takes too long
    timer = threading.Timer(5.0, run_process.kill)

    try:
        timer.start()
        run_output = run_process.communicate()[0]
    finally:
        timer.cancel()

    return run_output
