class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int m = matrix.length;
        if (m < 1) {
            throw new IllegalArgumentException("empty matrix - no rows");
        }
        final int n = matrix[0].length;
        if (n < 1) {
            throw new IllegalArgumentException("empty matrix - no columns");
        }
        final int[][] brsum = new int[m + 1][n + 1];
        for (int r = (m - 1); r >= 0; -- r) {
            for (int c = (n - 1); c >= 0; -- c) {
                final int val = matrix[r][c];
                if (val == k) {
                    return val;
                }
                brsum[r][c] = matrix[r][c] + brsum[r][c + 1] + brsum[r + 1][c] - brsum[r + 1][c + 1];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int r0 = 0; r0 < m; ++ r0) {
            for (int rf = r0; rf < m; ++ rf) {
                final int rfp1 = rf + 1;
                for (int c0 = 0; c0 < n; ++ c0) {
                    for (int cf = c0; cf < n; ++ cf) {
                        final int cfp1 = cf + 1;
                        final int sum = brsum[r0][c0] + brsum[rfp1][cfp1] - brsum[r0][cfp1] - brsum[rfp1][c0];
                        if (sum == k) {
                            return sum;
                        } else if (sum < k && sum > maxSum) {
                            maxSum = sum;
                        }
                    }
                }
            }
        }
        return maxSum;
    }

}
