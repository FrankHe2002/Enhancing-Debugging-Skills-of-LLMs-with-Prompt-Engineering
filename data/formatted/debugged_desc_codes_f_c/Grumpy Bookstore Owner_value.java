The bug in the provided Java code for the `maxSatisfied` method is the syntax error in the line `int start = - 0;` where `-` and `0` are unintentionally separated.

The line should be fixed to `int start = 0;` with the correct initialization value of `start`.

The fixed version of the code in markdown is as follows:

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