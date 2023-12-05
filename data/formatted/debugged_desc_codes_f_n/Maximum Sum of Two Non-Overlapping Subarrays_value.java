```java
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] dp = new int[nums.length];
        int maxSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i < firstLen) {
                maxSum += nums[i];
                dp[i] = maxSum;
            } else {
                maxSum += nums[i] - nums[i - firstLen];
                dp[i] = Math.max(maxSum, dp[i - 1]);
            }
        }
        
        int leftMaxSum = 0;
        maxSum = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + secondLen >= nums.length) {
                maxSum += nums[i];
                leftMaxSum = Math.max(leftMaxSum, maxSum);
            } else {
                maxSum += nums[i] - nums[i + secondLen];
                leftMaxSum = Math.max(leftMaxSum, maxSum);
            }
        }
        
        maxSum = 0;
        int result = 0;
        
        for (int i = firstLen - 1; i < nums.length - secondLen; i++) {
            maxSum = Math.max(maxSum, dp[i] + leftMaxSum);
            result = Math.max(result, maxSum);
        }
        
        int rightMaxSum = 0;
        maxSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i < secondLen) {
                maxSum += nums[i];
                dp[i] = maxSum;
            } else {
                maxSum += nums[i] - nums[i - secondLen];
                dp[i] = Math.max(maxSum, dp[i - 1]);
            }
        }
        
        maxSum = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + firstLen >= nums.length) {
                maxSum += nums[i];
                rightMaxSum = Math.max(rightMaxSum, maxSum);
            } else {
                maxSum += nums[i] - nums[i + firstLen];
                rightMaxSum = Math.max(rightMaxSum, maxSum);
            }
        }
        
        maxSum = 0;
        
        for (int i = secondLen - 1; i < nums.length - firstLen; i++) {
            maxSum = Math.max(maxSum, dp[i] + rightMaxSum);
            result = Math.max(result, maxSum);
        }

        return result;
    }
}
```