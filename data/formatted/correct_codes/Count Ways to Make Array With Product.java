class Solution {
    int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    int[][] SMALL_INT_FACTORS = {null, {1}, {2}, {3}, {2, 2}, {5}, {2, 3}, {7}, {2, 2, 2}, {3, 3}, {2, 5}, {11}, {2, 2, 3}, {13}};

    public int[] waysToFillArray(int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++ i)
            ans[i] = dewIt(queries[i]);
        return ans;
    }

    private int dewIt(int[] q) {
        long ans = 1;
        int k = q[0], num = q[1];
        for (int p : PRIMES) {
            int n = 0;
            while (num % p == 0) {
                num /= p;
                ++ n;
            }
            ans = multiply(ans, getSplitCount(n, k));
        }
        if (num > 1)
            ans = multiply(ans, k);
        return (int) ans;
    }

    private long getSplitCount(int n, int k) {
        int a = n + k - 1, b = k - 1;
        if ((b << 1) > a) b = a - b;
        return comb(a, b);
    }


    private long comb(int n, int r) {
        int[] numerators = new int[r];
        for (int i = 0, j = n; i < r; ++ i, -- j)
            numerators[i] = j;
        for (int i = 2; i <= r; ++ i) {
            int[] factors = SMALL_INT_FACTORS[i];
            for (int f : factors)
                for (int j = 0; ; ++ j)
                    if (numerators[j] % f == 0) {
                        numerators[j] /= f;
                        break;
                    }
        }
        long ans = 1;
        for (int num : numerators)
            ans = multiply(ans, num);
        return ans;
    }

    private long multiply(long v, long u) {
        return v * u % 1000000007;
    }
}