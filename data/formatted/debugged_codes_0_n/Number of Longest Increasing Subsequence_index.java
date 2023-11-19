class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int[] count = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxi = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                    maxi = Math.max(dp[i], maxi);
                } else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
                    count[i] += count[j];
                }
            }
        }
        int maxlis = 0;
        for (int i = 0; i < N; i++) {
            if (maxi == dp[i]) {
                maxlis += count[i];
            }
        }
        return maxlis;
    }
}