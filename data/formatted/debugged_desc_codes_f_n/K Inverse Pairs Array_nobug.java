```java
// Runtime: 28 ms (Top 65.12%) | Memory: 47.8 MB (Top 52.38%)
class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        int[][] opt = new int[k + 1][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    opt[i][j] = 1;
                } else {
                    opt[i][j] = (opt[i][j - 1] + opt[i - 1][j]) % MOD;
                    if (j > i) {
                        opt[i][j] = (opt[i][j] - opt[i - 1][j - i - 1] + MOD) % MOD;
                    }
                }
            }
        }

        return opt[k][n - 1];
    }
}
```