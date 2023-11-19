class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int output = Integer.MIN_VALUE;
        for (int i = 0, j = nums.length - 1; i < nums.length / 2; i++, j--) {
            output = Math.max(output, nums[i] + nums[j]);
        }

        return output;
    }
}