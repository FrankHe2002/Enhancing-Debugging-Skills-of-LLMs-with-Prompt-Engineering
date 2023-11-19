// Runtime: 3 ms (Top 67.02%) | Memory: 67.1 MB (Top 78.50+)
class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxJump < i) {
                return false;
            } else {
                maxJump = Math.max(maxJump, nums[i] + i);
            }
        }
        return true;
    }
}