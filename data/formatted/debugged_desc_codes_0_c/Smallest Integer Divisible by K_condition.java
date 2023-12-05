The provided Java code looks mostly correct, but there is a small bug in the code's condition for checking if there is no such 'n' that is divisible by 'k'.

The bug is in the line:
```java
if (hit[n])
    return - 1; // the remainder of the division repeats, so it starts to loop that means it cannot be divisible.
```

Here, there should not be a space after the '-' character in `return - 1;`. It should be `return -1;`.

To fix the bug, remove the space after the '-' character in the `return` statement.

Here's the corrected code:

```java
class Solution {
    public int smallestRepunitDivByK(int k) {
        boolean[] hit = new boolean[k];
        int n = 0, ans = 0;
        while (true) { // at most k times, because 0 <= remainder < k
            ++ ans;
            n = (n * 10 + 1) % k; // we only focus on whether to divide, so we only need to keep the remainder.
            if (n == 0) return ans; // can be divisible
            if (hit[n])
                return -1; // the remainder of the division repeats, so it starts to loop that means it cannot be divisible.
            hit[n] = true;
        }
    }
}
```