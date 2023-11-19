class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;
        Arrays.sort(nums);
        return nums[1];
    }
}