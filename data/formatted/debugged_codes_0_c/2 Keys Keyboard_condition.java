Bug type: Infinite loop

Reasoning: 
1. The while loop condition is `rem <= 0`, which means the loop will continue as long as `rem` is less than or equal to 0.
2. Inside the loop, the value of `rem` is updated by subtracting `copied` from it, which should decrease the value of `rem`.
3. However, if `copied` is always 0, then `rem` will never decrease, causing an infinite loop.

Fix: The condition in the while loop should be `rem > 0` instead of `rem <= 0`.

Updated code:
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
            onScreen = n - rem; // no. of characters on screen currently that can be copied in next copy operation
        }

        return ans;
    }
}
```