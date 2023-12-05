The bug in the provided code is in the logic of updating the dynamic programming array `dp`. The `if` conditions which update the `dp` array don't consider the current cell's value when making comparisons between previously calculated cells. This leads to incorrect results and suboptimal solutions.

To fix the bug, the `if` conditions must be rewritten to consider the current cell's value when updating the `dp` array.

Here's the corrected code:

```java
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int N = nums1.length, M = nums2.length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[N - 1][M - 1];
    }
}
```

In the revised code:
- The `if` conditions are updated to compare the current cell's value with the calculated value based on previous cells, using `Math.max` to properly update the `dp` array.
- This ensures that the maximum dot product of non-empty subsequences of `nums1` and `nums2` is correctly computed.