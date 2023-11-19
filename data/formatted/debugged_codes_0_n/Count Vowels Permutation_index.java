```java
// Runtime: 41 ms (Top 32.30%) | Memory: 52.8 MB (Top 39.76%)
class Solution {
    private long[][] dp;
    private int mod = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        dp = new long[6][n + 1];
        if (n == 1) return 5;

        for (int i = 0; i < 5; i++)
            dp[i][0] = 1;

        helper(n, 'a');
        return (int) dp[5][n];
    }

    private long helper(int n, char vowel) {
        if (dp[vowel - 'a'][n] != 0) return dp[vowel - 'a'][n];

        long ans = 0;
        if (n == 0) return 1;

        if (vowel == 'a') {
            ans = (ans + helper(n - 1, 'e')) % mod;
        } else if (vowel == 'e') {
            ans = (ans + helper(n - 1, 'a') + helper(n - 1, 'i')) % mod;
        } else if (vowel == 'i') {
            ans = (ans + helper(n - 1, 'a') + helper(n - 1, 'e') + helper(n - 1, 'o') + helper(n - 1, 'u')) % mod;
        } else if (vowel == 'o') {
            ans = (ans + helper(n - 1, 'i') + helper(n - 1, 'u')) % mod;
        } else {
            ans = (ans + helper(n - 1, 'a')) % mod;
        }

        dp[vowel - 'a'][n] = ans;

        return ans;
    }
}
```