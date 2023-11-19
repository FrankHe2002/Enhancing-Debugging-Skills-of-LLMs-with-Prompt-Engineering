class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dist = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE - 100000);
        }
        
        // Top-left to Bottom-right, dp[i][j] = min(dp[i][j], dp[i-1][j-1] + 1)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i-1][j-1] + 1);
                }
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        
        // Bottom-right to Top-left, dp[i][j] = min(dp[i][j], dp[i+1][j+1] + 1)
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i < m-1 && j < n-1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i+1][j+1] + 1);
                }
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        
        // Bottom-left to Top-right, dp[i][j] = min(dp[i][j], dp[i+1][j-1] + 1)
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i < m-1 && j > 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i+1][j-1] + 1);
                }
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        