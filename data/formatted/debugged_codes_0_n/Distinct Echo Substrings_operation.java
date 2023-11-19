class Solution {
    private static final int PRIME = 101;
    private static final int MOD = 1_000_000_007;

    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            long hash = 0;
            for (int j = i; j < n; j++) {
                hash = (hash * PRIME + (text.charAt(j) - 'a' + 1)) % MOD;
                dp[i][j] = (int) hash;
            }
        }

        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; 2 * j - i + 1 < n; j++) {
                if (dp[i][j] == dp[j + 1][2 * j - i + 1] && set.add(dp[i][j])) res++;
            }
        }

        return res;
    }
}