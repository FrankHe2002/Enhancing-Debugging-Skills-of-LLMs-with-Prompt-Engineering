```java
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        if (n == 0) return 1;

        int[][] dp = new int[n + 1][target + 1];
        int mod = 1000000007;
        for (int i = 1; i <= k; i++) {
            if (i <= target) {
                dp[1][i] = 1;
            }
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
```