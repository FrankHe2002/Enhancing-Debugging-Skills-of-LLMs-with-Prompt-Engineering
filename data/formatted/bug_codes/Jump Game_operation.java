class Solution {
    public boolean canJump(int[] nums) {
        int maxjump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxjump < i)
                return false;
            else
                maxjump = Math.max(maxjump, nums[i] + i);
        }
        return true;
    }
}

