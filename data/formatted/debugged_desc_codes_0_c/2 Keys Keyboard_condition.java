Bug type:
The while loop condition is incorrect, causing an infinite loop.

Reasoning:
1. The while loop condition is checking if the value of `rem` is less than or equal to 0. Since `rem` is initialized as `n - 1`, and `n` is always a positive integer, the condition `rem <= 0` will never be true, leading to an infinite loop.

Fix:
Change the while loop condition from `while (rem <= 0)` to `while (rem > 0)`.

Updated code:
```java
class Solution {
    public int minSteps(int n) {
        int rem = n - 1, copied = 0, ans = 0, onScreen = 1;

        while (rem > 0) { // Fix: change the loop condition
            if (rem % onScreen == 0) {
                ans++; // copy operation
                copied = onScreen;
            }
            rem -= copied;
            ans++; // paste operation
            onScreen = n - rem; // no. of characters on screen currently that can be copied in next copy operation
        }

        return ans;
    }
}
```