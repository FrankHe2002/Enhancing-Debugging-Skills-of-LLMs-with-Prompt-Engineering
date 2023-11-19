Bug type: Logical bug, incorrect assignment in conditionals

Reasoning:
1. The code calculates the maximum dot product between two arrays `nums1` and `nums2`.
2. The provided code tries to maximize the dot product by considering different possible subarrays of `nums1` and `nums2`.
3. The bug occurs in the conditions for updating `dp[i][j]` in the innermost loop.
    - In the first conditional (`if (i > 0 && j > 0 && dp[i - 1][j - 1] > 0)`), the update is correct as it adds the value of `dp[i - 1][j - 1]`.
    - In the second conditional (`if (i > 0 && dp[i - 1][j] > dp[i][j])`), there is an error. The code intends to update `dp[i][j]` if `dp[i - 1][j]` is greater. However, it mistakenly assigns `dp[i - 2][j]` instead of `dp[i - 1][j]`.
    - In the third conditional (`if (j > 0 && dp[i][j - 1] > dp[i][j])`), there is also an error. The code intends to update `dp[i][j]` if `dp[i][j - 1]` is greater. However, it mistakenly assigns `dp[i][j - 1]` instead of `dp[i][j]`.
4. To fix the bug, the correct assignments in the conditionals should be:
    - `dp[i][j] = dp[i - 1][j]` instead of `dp[i][j] = dp[i - 2][j]`
    - `dp[i][j] = dp[i][j - 1]` instead of `dp[i][j] = dp[i][j - 1]`

Fixed code:
```java
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int N = nums1.length, M = nums2.length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 