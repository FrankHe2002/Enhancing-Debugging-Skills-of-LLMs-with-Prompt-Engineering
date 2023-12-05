```java
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n - 1];
        for (int i = 1; i < n; i++) {
            dp[i - 1] = nums[i] - nums[i - 1];
        }
        int si = 0;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (dp[i] != dp[i - 1]) {
                count += (i - si);
            } else {
                si = i;
            }
        }
        return count;
    }
}
```