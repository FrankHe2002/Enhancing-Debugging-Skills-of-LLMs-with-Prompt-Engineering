```java
class Solution {

    public long maxProduct(String s) {
        int n = s.length();
        if (n == 2) return 1;
        int[] len = manachers(s);

        long[] left = new long[n];
        long maxLeft = 1;
        left[0] = maxLeft;
        for (int i = 1; i <= n - 1; i++) {
            if (len[(i - maxLeft - 1 + i) / 2] > maxLeft) maxLeft += 2;
            left[i] = maxLeft;
        }

        long[] right = new long[n];
        long maxRight = 1;
        right[n - 1] = maxRight;
        for (int i = n - 2; i >= 0; i--) {
            if (len[(i + maxRight + 1 + i) / 2] > maxRight) maxRight += 2;
            right[i] = maxRight;
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
        for (int i = 0; i < len; i++) {
            int mirror = (2 * c) - i;
            if (i < r) {
                P[i] = Math.min(r - i, P[mirror]);
            }
            int a = i + (1 + P[i]);
            int b = i - (1 + P[i]);
            while (a < len && b >= 0 && s.charAt(a) == s.charAt(b)) {
                P[i]++;
                a++;
                b--;
            }
            if (i + P[i] > r) {
                c = i;
                r = i + P[i];
            }
        }
        for (int i = 0; i < len; i++) P[i] = 1 + 2 * P[i];
        return P;
    }
}
```