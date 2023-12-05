The bug in the provided Java code is a logical error in the calculation of the maximum profit that can be earned from cutting the wood. The method `sellingWood` does not correctly calculate the maximum profit by considering all possible cuts.

To fix the bug, the algorithm must calculate the maximum profit by considering all possible cuts in both horizontal and vertical directions. This requires using nested loops to consider each possibility and updating the `dp` array accordingly.

Here's the fixed code:

```java
class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] price : prices) {
            dp[price[0]][price[1]] = price[2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - k][j] + dp[k][j]);
                }
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - k] + dp[i][k]);
                }
            }
        }
        return dp[m][n];
    }
}
```
The fixed code now correctly calculates the maximum profit that can be earned from selling the pieces of wood by considering all possible cuts.