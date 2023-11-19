The bug in the provided code is in the calculation of the `dp` array. The formula used to calculate `dp[i]` contains incorrect indices and incorrect addition/subtraction operations. 

The correct formula for calculating `dp[i]` should be:
```java
dp[i] = (dp[i - 1] + dp[i - 1] - dp[nextVisit[i - 1]] + 2 + mod) % mod;
```

Fixing the bug requires making the following changes:
1. Change `dp[nextVisit[i + 1]]` to `dp[nextVisit[i - 1]]`.
2. Add parentheses around the entire expression to ensure correct evaluation order.

Additionally, since `dp` is declared as a `long` array, the return type of the method should be updated to `long` instead of `int`.

Fixed code:

```java
class Solution {
    public long firstDayBeenInAllRooms(int[] nextVisit) {
        int rooms = nextVisit.length;
        long dp[] = new long[rooms];
        int mod = (int) (1e9) + 7;
        for (int i = 1; i < rooms; i++) {
            if (nextVisit[i - 1] == i - 1)
                dp[i] = (dp[i - 1] + 2) % mod;
            else
                dp[i] = (dp[i - 1] + dp[i - 1] - dp[nextVisit[i - 1]] + 2 + mod) % mod;
        }
        return dp[rooms - 1];
    }
}
```