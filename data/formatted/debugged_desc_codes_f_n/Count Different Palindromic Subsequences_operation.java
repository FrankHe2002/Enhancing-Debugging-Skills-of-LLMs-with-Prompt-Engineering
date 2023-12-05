```java
class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length(), M = (int) 1e9 + 7;
        int[][] next = new int[n][4];
        int[][] prev = new int[n][4];
        int[][][] dp = new int[n][n][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0, k = n - 1; j < n; j++, k--) {
                prev[j][i] = s.charAt(j) - 'a' == i ? j : (j == 0 ? -1 : prev[j - 1][i]);
                next[k][i] = s.charAt(k) - 'a' == i ? k : (k == n - 1 ? -1 : next[k + 1][i]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                int cur = s.charAt(i) - 'a';
                dp[i][j][cur] += i == j ? 1 : 2;
                for (int k = 0; k < 4 && j - i >= 2; k++) {
                    if (next[i][k] != -1 && prev[j][k] != -1) {
                        dp[i][j][cur] += dp[next[i][k] + 1][prev[j][k] - 1][k];
                        dp[i][j][cur] %= M;
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < 4; k++) {
            if (next[0][k] != -1 && prev[n - 1][k] != -1) {
                ans += dp[next[0][k]][prev[n - 1][k]][k];
                ans %= M;
            }
        }
        return ans;
    }
}
```