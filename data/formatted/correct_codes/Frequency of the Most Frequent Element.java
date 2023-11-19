class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int L = 0, R = 0;
        long totalSum = 0;
        int res = 1;
        while (R < nums.length) {
            totalSum += nums[R];
            while (! ((totalSum + k) >= ((R - L + 1) * nums[R]))) {
                totalSum -= nums[L];
                L++;
            }
            res = Math.max(res, (R - L + 1));
            R++;
        }
        return res;
    }
}