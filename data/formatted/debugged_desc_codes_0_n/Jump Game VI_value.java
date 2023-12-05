```java
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + dp[i - 1];
            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
            }
        }
        return dp[n - 1];
    }
}
```