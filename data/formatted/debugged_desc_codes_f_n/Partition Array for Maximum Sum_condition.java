```java
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSum(arr, k, 0);
    }

    public int maxSum(int[] arr, int k, int start) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int currentMax = 0, maxSum = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                currentMax = Math.max(currentMax, arr[i - j]);
                maxSum = Math.max(maxSum, dp[i - j] + currentMax * j);
            }
            dp[i] = maxSum;
        }
        return dp[n];
    }
}
```