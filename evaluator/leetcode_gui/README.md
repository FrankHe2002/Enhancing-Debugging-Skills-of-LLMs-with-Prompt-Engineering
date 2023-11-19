### Instructions
1. Open up a web browser and go to any LeetCode problem
2. Switch to dynamic layout! A window should pop up when you enter a leetcode question, but if not, make sure to switch to it.
3. Open the inspect element/console panel
4. Run test.py to print mouse location. Using it, find the following locations:
    - TEXT_INPUT: Inside the main code input box
    - CONSOLE: The bottom of the console. Specifically, if you span the console enough that the scroll bar appears, and scroll to the bottom, where do you need to click to start entering text?
    - OUTPUT_COPY_LOCATION: Run the default leetcode code (that is, submit it for grading), so that you get some result (probably a compilation error). Then, run (copy-paste) the EXTRACTION_JS code in the console, and it should print out an element. The code will right click the element and then (in the menu) click copy; OUTPUT_COPY_LOCATION is the location the code needs to do the *right click*.
    - URL_BAR: Self-explanatory. Where should the code click to type in a new url?
5. Update `leetcode_eval.py` with the locations you found
6. Change LeetCode to use Java.
7. Run the code, and quickly switch back to the browser window. Don't touch while program is working.
    - leetcode_eval.py doesn't actually have any code in it. To run code, call run_code(...). An example is provided below.


```python

# Once run_code is called, it will immediately start clicking.
#   So, since you don't want to clicking around in your IDE,
#   make it wait so you have time to switch back to the browser.
time.sleep(5)

# Not a real problem/code, just an example call
res = run_code("matrix-character", "class Solution {\nint answer() {\nreturn 0;\n}\n}")
# res = (# test cases passed, test cases total, status message)
# Note that status messages can include Accepted, Time Limit Exceeded, Compile Error, etc.
# If code was accepted, # test cases passed and test cases total will both be 1, so res = (1, 1, "Accepted").

# A second call, if you have more problems to evaluate.
res = run_code("other-problem", "class Solution {\nint answer() {\nreturn 0;\n}\n}")

```