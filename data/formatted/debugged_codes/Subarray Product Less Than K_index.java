class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        int length = 0;
        long product = 1;
        int i = 0;
        int j = 0;
        int n = nums.length;
        int ans = 0;

        while (j < n) {
            product *= nums[j];

            if (product < k) {
                length += 1;
                ans += length;
            } else {
                while (i <= j && product >= k) {
                    product /= nums[i];
                    i++;
                }

                ans += (j - i) + 1;
                length = j - i + 1;
            }

            j++;
        }

        return ans;
    }
}