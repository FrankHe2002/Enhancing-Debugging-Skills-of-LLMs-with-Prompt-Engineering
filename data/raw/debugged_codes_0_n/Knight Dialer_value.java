class Solution {
    public int knightDialer(int n) {
        long[] dp = new long[10];
        long[] tmp = new long[10];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            tmp[1] = (dp[6] + dp[8]) % 1000000007;
            tmp[2] = (dp[7] + dp[9]) % 1000000007;
            tmp[3] = (dp[4] + dp[8]) % 1000000007;
            tmp[4] = (dp[0] + dp[3] + dp[9]) % 1000000007;
            tmp[5] = 0;
            tmp[6] = (dp[0] + dp[1] + dp[7]) % 1000000007;
            tmp[7] = (dp[2] + dp[6]) % 1000000007;
            tmp[8] = (dp[1] + dp[3]) % 1000000007;
            tmp[9] = (dp[2] + dp[4]) % 1000000007;
            tmp[0] = (dp[4] + dp[6]) % 1000000007;
            var arr = dp;
            dp = tmp;
            tmp = arr;
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[i]) % 1000000007;
        }
        return (int)res;
    }
}