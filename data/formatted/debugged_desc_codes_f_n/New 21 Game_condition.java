```java
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[k + maxPts];
        dp[0] = 1;
        for (int i = 1; i < k + maxPts; i++) {
            for (int j = 1; j <= maxPts && i + j <= n; j++) {
                dp[i + j] += dp[i] * 1.0 / maxPts;
            }
        }

        double ans = 0;
        for (int i = k; i <= n && i < k + maxPts; i++) {
            ans += dp[i];
        }

        return ans;
    }
}
```