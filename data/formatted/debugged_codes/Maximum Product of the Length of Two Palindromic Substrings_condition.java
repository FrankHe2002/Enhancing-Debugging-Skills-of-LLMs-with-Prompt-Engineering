class Solution {

    public long maxProduct(String s) {
        int n = s.length();
        if (n == 2) return 1;
        int[] len = manachers(s);

        long[] left = new long[n];

        int max = 1;
        left[0] = max;
        for (int i = 1; i < n - 1; i++) {
            if (len[(i - max - 1 + i) / 2] > max) max += 2;
            left[i] = max;
        }
        max = 1;
        long[] right = new long[n];
        right[n - 1] = max;

        for (int i = n - 2; i >= 0; i--) {
            if (len[(i + max + 1 + i) / 2] > max) max += 2;
            right[i] = max;
        }

        long res = 1;

        for (int i = 1; i < n; i++) {
            res = Math.max(res, left[i - 1] * right[i]);
        }
        return res;
    }

    private int[] manachers(String s) {

        int len = s.length();
        int[] P = new int[len];
        int c = 0;
        int r = 0;
        int maxLen = 0;

        for (int i = 0; i < len; i++) {