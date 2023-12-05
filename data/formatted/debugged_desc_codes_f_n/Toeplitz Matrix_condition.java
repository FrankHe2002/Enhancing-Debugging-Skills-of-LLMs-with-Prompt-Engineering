```java
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int row = i;
            int col = 0;
            int e = matrix[row++][col++];
            while (row < n && col < m) {
                if (e != matrix[row][col]) {
                    return false;
                }
                row++;
                col++;
            }
        }

        for (int i = 1; i < m; i++) {
            int row = 0;
            int col = i;
            int e = matrix[row++][col++];
            while (row < n && col < m) {
                if (e != matrix[row][col]) {
                    return false;
                }
                row++;
                col++;
            }
        }

        return true;
    }
}
```