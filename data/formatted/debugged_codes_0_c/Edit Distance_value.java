The bug in the provided Java code is a logical error. 

The code initializes the `dp` array with dimensions `m` by `n`, but the loop for initialization is incorrectly using `m` and `n` as indexes instead of dimensions. This will cause an `IndexOutOfBoundsException` when accessing elements in the `dp` array.

To fix this bug, we need to change the initialization loop to use the correct dimensions of `dp`, which are `m + 1` by `n + 1`.

Here's the fixed code:

```java
class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m + 1][n + 1]; // Change the dimensions of dp
        for (int i = 0; i <= m; i++) { // Use m + 1
            for (int j = 0; j <= n; j++) { // Use n + 1
                dp[i][j] = -1;
            }
        }
        return solve(word1, word2, m, n, dp); // Pass m and n instead of m - 1 and n - 1
    }

    public int solve(String str1, String str2, int m, int n, int dp[][]) {
        if (m < 0) {
            return n + 1;
        }
        if (n < 0) {
            return m + 1;
        }
        if (dp[m][n] != -1) { // Use -1 instead of -2
            return dp[m][n];
        }
        if (str1.charAt(m) == str2.charAt(n)) {
            return solve(str1, str2, m - 1, n - 1, dp);
        } else {
            int min = Math.min(solve(str1, str2, m - 1, n, dp), solve(str1, str2, m, n - 1, dp));
            dp[m][n] = 1 + Math.min(min, solve(str1, str2, m - 1, n - 1, dp));
        }
        return dp[m][n];
    }
}
```