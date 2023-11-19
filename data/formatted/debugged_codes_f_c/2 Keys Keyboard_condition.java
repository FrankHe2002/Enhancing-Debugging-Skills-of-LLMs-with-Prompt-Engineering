Bug Type: Logical Error

Reasoning:
1. The loop condition `while (rem <= 0)` is incorrect. It should be `while (rem > 0)` to continue the loop until `rem` becomes zero.
2. The calculation of `onScreen` is incorrect. It should be `onScreen = rem` instead of `onScreen = n - rem`.

Fix:
```java
class Solution {
    public int minSteps(int n) {
        int rem = n - 1, copied = 0, ans = 0, onScreen = 1;

        while (rem > 0) {
            if (rem % onScreen == 0) {
                ans++; // copy operation
                copied = onScreen;
            }
            rem -= copied;
            ans++; // paste operation
            onScreen = rem; // no. of characters on screen currently that can be copied in next copy operation
        }

        return ans;
    }
}
```