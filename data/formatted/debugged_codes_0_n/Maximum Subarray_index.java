class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currmax = nums[0];
        int gmax = nums[0];
        for (int i = 1; i < n; i++) {
            currmax = Math.max(nums[i], currmax + nums[i]);
            gmax = Math.max(gmax, currmax);
        }
        return gmax;
    }
}