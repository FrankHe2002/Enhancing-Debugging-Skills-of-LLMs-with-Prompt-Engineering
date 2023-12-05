```java
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] dp = new int[n];
        dp[0] = values[0] + 0; // Calculate initial dp value
        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], values[i] + i); // Update dp value
            ans = Math.max(ans, dp[i] + values[i] - i); // Update ans with max score
        }
        return ans;
    }
}
```