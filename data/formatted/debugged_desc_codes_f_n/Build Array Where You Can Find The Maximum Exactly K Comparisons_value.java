```java
class Solution {
    public int numOfArrays(int n, int m, int k) {
        int M = (int) 1e9 + 7;
        int ans = 0;
        int[][] dp = new int[m + 1][k + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int[][] next = new int[m + 1][k + 1];
            for (int j = 1; j <= m; j++) {
                for (int p = 1; p <= m; p++) { 
                    for (int w = 1; w <= k; w++) { 
                        if (j > p) {
                            next[j][w] += dp[p][w - 1];
                            next[j][w] %= M;
                        } else { 
                            next[p][w] += dp[p][w];
                            next[p][w] %= M;
                        }
                    }
                }
            }
            dp = next;
        }
        for (int i = 1; i <= m; i++) {
            ans += dp[i][k];
            ans %= M;
        }
        return ans;
    }
}
```