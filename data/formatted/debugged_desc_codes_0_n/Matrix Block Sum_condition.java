```java
// Runtime: 88 ms (Top 26.15%) | Memory: 43.2 MB (Top 92.07%)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                int p = Math.max(i - k, 0), q = Math.max(j - k, 0);
                for (int x = p; x <= Math.min(i + k, m - 1); x++) {
                    for (int y = q; y <= Math.min(j + k, n - 1); y++) {
                        val += mat[x][y];
                    }
                }
                answer[i][j] = val;
            }
        }
        return answer;
    }
}
```