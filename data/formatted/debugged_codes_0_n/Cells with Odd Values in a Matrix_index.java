```java
// --------------------- Solution 1 ---------------------
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        for (int k = 0; k < indices.length; k++) {
            int row = indices[k][0];
            int col = indices[k][1];

            for (int j = 0; j < n; j++) {
                matrix[row][j]++;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][col]++;
            }
        }

        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) {
                    counter++;
                }
            }
        }

        return counter;
    }
}

// --------------------- Solution 2 ---------------------
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        for (int k = 0; k < indices.length; k++) {
            row[indices[k][0]]++;
            col[indices[k][1]]++;
        }

        int counter = 0;
        for (int i : row) {
            for (int j : col) {
                counter += (i + j) % 2 == 0 ? 0 : 1;
            }
        }

        return counter;
    }
}
```