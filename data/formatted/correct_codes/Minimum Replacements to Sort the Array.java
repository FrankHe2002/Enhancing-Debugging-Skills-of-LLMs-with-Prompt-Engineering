class Solution {
    public long minimumReplacement(int[] nums) {
        long ret = 0L;
        int n = nums.length;
        int last = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= last) {
                last = nums[i];
                continue;
            }
            if (nums[i] % last == 0) {
                ret += nums[i] / last - 1;
            } else {
                int k = nums[i] / last + 1;
                ret += k - 1;
                last = nums[i] / k;
            }

        }

        return ret;
    }

}