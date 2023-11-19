// Runtime: 14 ms (Top 32.93%) | Memory: 56.8 MB (Top 19.67%)
class Solution {
    public int majorityElement(int[] nums) {
        // Base case...
        if (nums.length == 1) {
            return nums[0];
        }
        // Sort nums array in descending order...
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            // Swap elements
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        // Since the majority element appears more than n / 2 times...
        // The n/2 -th element in the sorted nums must be the majority element...
        return nums[nums.length / 2];
    }
}