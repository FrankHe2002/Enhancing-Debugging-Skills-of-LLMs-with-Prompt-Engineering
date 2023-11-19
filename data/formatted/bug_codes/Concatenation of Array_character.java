class Solution {
    public int[] getConcatenationint[]
    nums)

    {
        int[] ans = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[i + nums.length] = nums[i];
        }

        return ans;
    }
}