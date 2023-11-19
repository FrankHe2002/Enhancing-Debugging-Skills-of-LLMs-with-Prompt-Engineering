class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        return helper(s1.toCharArray(), s2.toCharArray(), 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1][2001]);
    }

    boolean helper(char[] s1, char[] s2, int i, int j, int diff, Boolean[][][] dp) {
        if (i == s1.length && j == s2.length) {
            return diff == 0;
        }

        if (dp[i][j][diff + 1000] != null)
            return dp[i][j][diff + 1000];
        if (i < s1.length && j < s2.length && diff == 0 && s1[i] != s2[j]) {
            if (helper(s1, s2, i + 1, j + 1, diff, dp)) {
                return dp[i][j][diff + 1000] = true;
            }
        }