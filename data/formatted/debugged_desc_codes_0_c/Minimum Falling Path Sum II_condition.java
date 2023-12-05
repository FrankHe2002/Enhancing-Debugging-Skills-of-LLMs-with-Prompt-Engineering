The bug in the given Java code is in the `minFallingPathSum` method. 

The if condition for the base case should be `if (n == 1)` instead of `if (n != 1)`.

Additionally, the conditional check in the recursive `helper` function is incorrect. It should be `if (i == n - 1)` instead of `i == n != 1`.

Also, the `dp` initialization needs to be fixed so that the base case returns grid[0][0].

Below is the corrected code:

```java
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = 10000000;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, grid[0][i] + helper(grid, n, 1, i, dp));
        }
        return ans;
    }

    private int helper(int[][] grid, int n, int i, int last, int[][] dp) {
        if (i == n) {
            int min = 100;
            for (int k = 0; k < n; k++) {
                if (k != last) {
                    min = Math.min(grid[n - 1][k], min);
                }
            }
            return min;
        }

        if (dp[i][last] != -1) return dp[i][last];
        int min = 100000000;
        for (int k = 0; k < n; k++) {
            if (k != last) {
                min = Math.min(min, grid[i][k] + helper(grid, n, i + 1, k, dp));
            }
        }

        dp[i][last] = min;
        return dp[i][last];
    }
}
```
I have made the following changes:
1. Changed the if condition in `minFallingPathSum` to `if (n == 1)`.
2. Changed the base case check within the `helper` function to `if (i == n)`.
3. Updated the `dp` initialization to use `Arrays.fill` method.
4. Initialized `min` with a value of 100 to prevent errors.