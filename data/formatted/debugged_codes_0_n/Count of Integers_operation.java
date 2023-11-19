class Solution {
    private static final int M = 1000000007;


    private int add(int x, int y) {
        int sum = x + y;
        if (sum >= M) {
            sum %= M;
        }
        return sum;
    }


    private int sub(int x, int y) {
        int diff = x - y;
        if (diff < 0) {
            diff += M;
        }
        return diff;
    }


    private int count(String s, int min_sum, int max_sum) {
        final int n = s.length(), m = Math.min(max_sum, 9 * n);
        int[][][] dp = new int[2][2][m + 1];
        dp[0][0][0] = 1;
        int last = 0;
        for (int i = 0, p = 0; i < n; ++ i, p += 9) {
            final int now = last ^ 1;
            dp[now] = new int[2][m + 1];
            for (int j = 0; j < 2; ++ j) {
                for (int k = 0; k <= m && k <= p; ++ k) {
                    if (dp[last][j][k] == 0) {
                        continue;
                    }
                    for (char c = j != 0 ? '9' : s.charAt(i); c >= '0'; -- c) {
                        final int q = k + c - '0';
                        if (q <= m) {
                            dp[now][j != 0 || c < s.charAt(i) ? 1 : 0][q] = add(dp[now][j != 0 || c < s.charAt(i) ? 1 : 0][q], dp[last][j][k]);
                        }
                    }
                }
            }
            last ^= 1;
        }
        int r = 0;
        for (int i = 0; i < 2; ++ i) {
            for (int j = min_sum; j <= m; ++ j) {
                r = add(r, dp[last][i][j]);
            }
        }
        return r;
    }

