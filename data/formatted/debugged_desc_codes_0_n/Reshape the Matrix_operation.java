```java
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if (r * c != mat.length * mat[0].length) {
            return mat;
        }

        int[][] ans = new int[r][c];

        int x = 0;
        int y = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (y == c) {
                    x++;
                    y = 0;
                }
                ans[x][y++] = mat[i][j];
            }
        }
        return ans;
    }
}
```