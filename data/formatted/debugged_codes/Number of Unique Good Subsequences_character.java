class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int initialZeroCount = 0;
        while (initialZeroCount < binary.length() && binary.charAt(initialZeroCount) == '0') {
            initialZeroCount++;
        }
        if (initialZeroCount == binary.length()) {
            return 1;
        }
        long[] dp = new long[binary.length()];
        dp[initialZeroCount] = 1;
        int lastOne = - 1, lastZero = - 1;
        long mod = (long) Math.pow(10, 9) + 7;
        for (int i = initialZeroCount + 1; i < binary.length(); i++) {
            int j = binary.charAt(i) == '1' ? lastOne : lastZero;
            long dup = j >= 0 ? dp[j] : 0;
            dp[i] = (2 * dp[i - 1] - dup + mod) % mod;
            if (binary.charAt(i) == '0') {
                lastZero = i;
            } else {
                lastOne = i;
            }
        }

        int hasZero = binary.contains("0") ? 1 : 0;

        return (int) (dp[binary.length() - 1] + hasZero);
    }
}