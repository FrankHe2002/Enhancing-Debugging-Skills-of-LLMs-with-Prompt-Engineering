The bug in the code is in the while loop condition. Currently, the loop only iterates when the condition `rem <= 0` is met, which is never satisfied since `rem` is initialized as `n - 1`. Additionally, the condition `if (rem % onScreen == 0)` appears to be redundant since the loop should handle the copying and pasting until `rem` reaches 0.
The fix involves changing the while loop condition to `while (rem > 0)`, removing the redundant condition inside the loop, and correcting the calculation of `onScreen`.

```java
class Solution {
    public int minSteps(int n) {
        int rem = n - 1, copied = 0, ans = 0, onScreen = 1;

        while (rem > 0) {
            if (rem % onScreen == 0) {
                copied = onScreen;
            }
            rem -= copied;
            ans++;
            onScreen = rem; 
        }

        return ans;
    }
}
```