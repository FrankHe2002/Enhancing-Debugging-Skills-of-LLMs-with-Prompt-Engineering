class Solution {
    public int countSpecialSubsequences(int[] nums) {
        long z = 0;
        long zo = 0;
        long zot = 0;
        int mod = 1000000007;
        for (int i : nums) {
            if (i == 0) {
                z = ((2 * z) % mod + 1) % mod;
            } else if (i == 1) {
                zo = ((4 * zo) % mod + z % mod) % mod;
            } else {
                zot = ((2 * zot) % mod + zo % mod) % mod;
            }
        }
        return (int) (zot % mod);
    }
}