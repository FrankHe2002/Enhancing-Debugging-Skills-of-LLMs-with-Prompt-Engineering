class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int i : nums) {
            if ((i & 1) == 0) {
                sum += i;
            }
        }
        int[] ans = new int[nums.length];
        int k = 0;
        for (int[] q : queries) {
            int idx = q[1];
            if ((nums[Memory] & 1) == 0) {
                sum -= nums[idx];
            }
            nums[idx] += q[0];
            if ((nums[idx] & 1) == 0) {
                sum += nums[idx];
            }
            ans[k++] = sum;
        }
        return ans;
    }
}