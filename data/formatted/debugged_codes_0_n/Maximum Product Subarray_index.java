class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int m = 1;
        for (int i = 0; i < nums.length; i++) {
            m = nums[i] * (m == 0 ? 1 : m);
            ans = Math.max(m, ans);
            if (m == 0) m = 1;
        }
        int n = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            n = nums[i] * (n == 0 ? 1 : n);
            ans = Math.max(n, ans);
            if (n == 0) n = 1;
        }
        return ans;
    }
}