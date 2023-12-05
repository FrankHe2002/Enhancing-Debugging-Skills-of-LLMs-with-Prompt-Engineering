```java
class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int initialZeroCount = 0;
        while (initialZeroCount < binary.length() && binary.charAt(initialZeroCount) == '0') initialZeroCount++;
        if (initialZeroCount == binary.length()) return 1;
        long[] dp = new long[binary.length()];
        dp[initialZeroCount] = 1;
        int lastOne = -1, lastZero = -1;
        long mod = (long) Math.pow(10, 9) + 7;
        for (int i = initialZeroCount; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                lastOne = i;
                if (lastZero != -1) {
                    dp[i] = (dp[lastZero] + dp[lastOne]) % mod;
                } else {
                    dp[i] = (1 + dp[lastOne]) % mod;
                }
            } else {
                lastZero = i;
                dp[i] = (dp[lastOne] + dp[lastZero]) % mod;
            }
        }
        return (dp[binary.length() - 1] + (binary.contains("0") ? 1 : 0)) % mod;
    }
}
```