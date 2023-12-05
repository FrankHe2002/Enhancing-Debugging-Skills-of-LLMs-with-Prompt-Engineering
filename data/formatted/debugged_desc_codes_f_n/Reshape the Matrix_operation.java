```java
// Runtime: 1 ms (Top 90.50%) | Memory: 50.7 MB (Top 48.08%)
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if (r * c != mat.length * mat[0].length) {
            return mat;
        }

        int[][] ans = new int[r][c];

        int cr = 0;
        int cc = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (cc == c) {
                    cr++;
                    cc = 0;
                }
                ans[cr][cc++] = mat[i][j];
            }
        }
        return ans;
    }
}
```