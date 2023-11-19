class Solution {
    public boolean find132pattern(int[] nums) {
        int min = Integer.MIN_VALUE;
        int peak = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min)
                return true;
            while (peak < nums.length && nums[i] > nums[peak])
                min = nums[peak++];
            peak--;
            nums[peak] = nums[i];
        }
        return false;
    }
}