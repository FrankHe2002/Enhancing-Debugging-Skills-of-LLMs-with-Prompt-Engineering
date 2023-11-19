```java
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n + 1];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= maxPts; j++) {
                if (i + j <= n) {
                    dp[i + j] += dp[i] * 1.0 / maxPts;
                }
            }
        }

        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }

        return ans;
    }
}
```