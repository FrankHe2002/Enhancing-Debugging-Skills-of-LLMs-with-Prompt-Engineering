class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        if (n == 1)
            return 0;

        Arrays.sort(nums);

        if (k >= nums[n - 1] - nums[0]) {
            return nums[n - 1] - nums[0];
        }

        int minScore = nums[n - 1] - nums[0];
        for (int p = 1; p < n; p++) {
            int min = Math.min(nums[0] + k, nums[p] - k);
            int max = Math.max(nums[p - 1] + k, nums[n - 1] - k);
            minScore = Math.min(minScore, max - min);
        }

        return minScore;
    }
}