The bug in the code is in the second for loop where the nested loop conditions are incorrect. Also, there is a mistake in the `swap` method arguments where the arguments are swapped.

Here is the fixed code:

```java
class Solution {
    public void swap(int[][] matrix, int n1, int m1, int n2, int m2) {
        int temp = matrix[n1][m1];
        matrix[n1][m1] = matrix[n2][m2];
        matrix[n2][m2] = temp;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                swap(matrix, i, j, j, n - i - 1);
                swap(matrix, i, j, n - i - 1, n - j - 1);
                swap(matrix, i, j, n - j - 1, i);
            }
        }
    }
}
```