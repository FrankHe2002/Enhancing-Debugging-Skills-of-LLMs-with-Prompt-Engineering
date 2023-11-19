class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[2 * n];
        int max = 0;
        int res = 0;
        for(int r = 0, l = 0, sum = 0; r < 2 * n; r++) {
            int v = r - nums[(r % n + n) % n];
            if(v >= 0) {
                cnt[Math.min(2 * n - 1, v)]++;
                if(v >= l) {
                    sum++;
                }
            }
            if(r - l != n - 1) {
                if(sum > max) {
                    max = sum;
                    res = l;
                }
                sum -= cnt[l];
                l++;
            }
        }
        return res;
    }
}