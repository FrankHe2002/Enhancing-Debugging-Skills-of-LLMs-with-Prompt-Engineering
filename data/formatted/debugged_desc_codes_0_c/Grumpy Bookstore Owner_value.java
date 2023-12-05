The bug in the code is with the line int start = - 0; which should be int start = 0;.

Here's the step-by-step reasoning process for identifying and fixing the bug:
1. The variable "start" is meant to keep track of the start of the "minutes" window.
2. The typo `- 0` doesn't make sense and will cause the program to malfunction.
3. Changing the variable initialization to int start = 0; will fix the bug.

Here's the corrected code:

```java
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0;
        int count = 0;

        int max = 0;
        int curr = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                count += customers[i];
            } else {
                curr += customers[i];
            }

            if (i - start > minutes) {
                start++;
                if (grumpy[start] == 1) {
                    curr -= customers[start];
                }
            }
            max = Math.max(max, curr);
        }

        return count + max;
    }
}
```