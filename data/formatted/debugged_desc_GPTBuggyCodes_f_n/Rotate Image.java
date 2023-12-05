```java
class Solution {
    public void swap(int[][] matrix, int n1, int m1, int n2, int m2) {
        int a = matrix[n1][m1];
        matrix[n1][m1] = matrix[n2][m2];
        matrix[n2][m2] = a;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - i - 1, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
}
```