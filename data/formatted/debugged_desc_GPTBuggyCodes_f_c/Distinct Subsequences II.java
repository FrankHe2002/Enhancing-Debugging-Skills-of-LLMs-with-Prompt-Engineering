```java
class Solution {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        Integer[] li = new Integer[26];
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        char[] c = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            int curr = (2 * (dp[i - 1] % mod)) % mod;
            int idx = c[i - 1] - 'a';
            if (li[idx] != null) dp[i] = (curr - dp[li[idx]] + mod) % mod;
            else dp[i] = curr;
            li[idx] = i;
        }
        return (dp[n] - 1 + mod) % mod;
    }
}
```