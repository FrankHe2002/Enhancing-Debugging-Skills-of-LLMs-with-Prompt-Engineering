class Solution {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (var i = 0; i < n - 1; i++)
            ans = Math.max(ans, nums[i + 1] - nums[i]);

        return ans;
    }
}