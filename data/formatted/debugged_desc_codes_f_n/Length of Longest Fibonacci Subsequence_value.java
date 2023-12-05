```java
// Runtime: 46 ms (Top 97.5%) | Memory: 54.76 MB (Top 33.3%)

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        int result = 0;
        for (int k = 2; k < n; k++) {
            int i = 0, j = k - 1;
            while (i < j) {
                int sum = A[i] + A[j] - A[k];
                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else {
                    // ith, jth kth element are fibbonaci sequence
                    dp[j][k] = dp[i][j] + 1; // since numbers are unique
                    result = Math.max(result, dp[j][k]);
                    i++;
                    j--;
                }
            }
        }
        return result >= 2 ? result + 2 : 0;
    }
}
```