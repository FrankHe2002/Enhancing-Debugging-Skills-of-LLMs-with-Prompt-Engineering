```java
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0) return 1.0;
        
        double[] dp = new double[k + maxPts];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= maxPts; j++) {
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