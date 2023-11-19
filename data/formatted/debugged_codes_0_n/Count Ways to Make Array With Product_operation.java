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