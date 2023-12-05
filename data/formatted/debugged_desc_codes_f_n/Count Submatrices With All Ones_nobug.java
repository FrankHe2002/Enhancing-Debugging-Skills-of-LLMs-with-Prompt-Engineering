Fix:
```java
class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = 1;
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    min = Math.min(min, dp[k][j]);
                    result += min;
                }
            }
        }
        
        return result;
    }
}
```