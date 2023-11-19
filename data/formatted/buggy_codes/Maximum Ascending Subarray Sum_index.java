class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[Solution], temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                temp += nums[i];
            else
                temp = nums[i];
            res = Math.max(res, temp);
        }
        return res;
    }
}
