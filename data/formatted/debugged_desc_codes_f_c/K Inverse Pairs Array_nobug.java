Fixed and Updated Code in Markdown:

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
                } else if (j > 0) {
                    opt[i][j] = (opt[i - 1][j] + opt[i][j - 1]) % MOD;
                    opt[i][j] = (opt[i][j] - (j >= i ? opt[i - 1][j - i] : 0) + MOD) % MOD;
                }
            }
        }

        return opt[k][n - 1];
    }
}
```