// Runtime: 1 ms (Top 99.99%) | Memory: 56.7 MB (Top 38.67%)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}