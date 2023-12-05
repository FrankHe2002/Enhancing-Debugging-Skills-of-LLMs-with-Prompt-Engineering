The bug in Solution 1 is that when trying to get the row and column indices, the array index used is incorrect, and the loop in the second for loop also uses the wrong variable.

The bug in Solution 2 is in the nested loops while trying to calculate the number of odd-valued cells after applying the increments to all locations in indices.

A simple solution to this problem is to correct the implementation so that the proper row and column indices are used and the proper calculations are made to determine the number of odd-valued cells in the matrix.

```java
// --------------------- Solution 1 ---------------------
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];

            for (int j = 0; j < n; j++) {
                matrix[row][j]++;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][col]++;
            }
        }

        int counter = 0;
        for (int[] row : matrix) {
            for (int j : row) {
                if (j % 2 != 0) {
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

        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }

        int rowCount = 0;
        int colCount = 0;
        for (int i : row) {
            if (i % 2 != 0) {
                rowCount++;
            }
        }
        for (int j : col) {
            if (j % 2 != 0) {
                colCount++;
            }
        }

        return (m * colCount) + (n * rowCount) - (rowCount * colCount * 2);
    }
}
```