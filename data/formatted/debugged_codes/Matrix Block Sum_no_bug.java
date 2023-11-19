class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                int p = i - k, q = j - k;
                while (p < 0)
                    p++;
                while (q < 0)
                    q++;
                for (int x = p; x <= i + k && x < m; x++) {
                    for (int y = q; y <= j + k && y < n; y++) {
                        val += mat[x][y];
                    }
                }
                answer[i][j] = val;
            }
        }
        return answer;
    }
}