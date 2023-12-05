The bug in the provided code is in the initialization of the dp array. The code initializes the dp array as `dp[m][n]`, which should actually be `dp[m+1][n+1]` as the length of the strings is `m` and `n`, so the array should have dimensions `m+1` and `n+1` to store the results for each index.

Additionally, in the solve function, the check for the value of the dp array should be `if (dp[m][n] != - 1)` instead of `if (dp[m][n] != - 2)`.

To fix this, we can modify the code as follows:

```java
class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(word1, word2, m, n, dp);
    }

    public int solve(String str1, String str2, int m, int n, int dp[][]) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return solve(str1, str2, m - 1, n - 1, dp);
        } else {
            int min = Math.min(solve(str1, str2, m - 1, n, dp), solve(str1, str2, m, n - 1, dp));
            dp[m][n] = 1 + Math.min(min, solve(str1, str2, m - 1, n - 1, dp));
        }
        return dp[m][n];
    }
}
```

In the modified code:
- The dp array is now initialized with dimensions `m+1` and `n+1`, and the values are initialized to `-1` to ensure correct indexing and storage of results for each index.
- The solve function now has corrected conditions and also checks if the dp value exists for a given index before calculating or returning the value.

These changes should fix the bug in the provided code.