```java
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[k + maxPts];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= maxPts; j++) {
                if (i + j < dp.length) {
                    dp[i + j] += dp[i] / maxPts;
                }
            }
        }

        double ans = 0;
        for (int i = k; i <= n && i < dp.length; i++) {
            ans += dp[i];
        }

        return ans;
    }
}
```