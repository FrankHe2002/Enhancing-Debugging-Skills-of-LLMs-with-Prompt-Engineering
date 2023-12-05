```java
// Runtime: 12 ms (Top 94.21%) | Memory: 40.8 MB (Top 96.38%)
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        if (n == 1) return target <= k ? 1 : 0;

        int mod = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= target; j++) {
                for (int x = 1; x <= k && x <= j; x++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % mod;
                }
            }
        }
        return dp[n][target];
    }
}
```