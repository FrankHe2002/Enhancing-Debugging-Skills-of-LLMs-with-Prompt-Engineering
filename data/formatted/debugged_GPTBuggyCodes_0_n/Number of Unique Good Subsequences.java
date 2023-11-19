```java
class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int initialZeroCount = 0;
        while (initialZeroCount < binary.length() && binary.charAt(initialZeroCount) == '0') initialZeroCount++;
        if (initialZeroCount == binary.length()) return 1;
        
        long[] dp = new long[binary.length() + 1];
        dp[initialZeroCount] = 1;
        int lastOne = 0, lastZero = 0;
        long mod = (long) Math.pow(10, 9) + 7;
        
        for (int i = initialZeroCount + 1; i <= binary.length(); i++) {
            int j = i - 1;
            while (j >= initialZeroCount && binary.charAt(j) != binary.charAt(i-1)) {
                j--;
            }
            long dup = (j > initialZeroCount - 1) ? dp[j] : 0;
            dp[i] = (dp[i - 1] * 2 - dup + mod) % mod;
            
            if (binary.charAt(i - 1) == '0') lastZero = i;
            else lastOne = i;
        }

        int hasZero = (binary.indexOf('0') != -1) ? 1 : 0;

        return (int) (dp[binary.length()] + hasZero);
    }
}
```