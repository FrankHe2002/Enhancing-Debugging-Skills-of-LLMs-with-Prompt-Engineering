Problem:
The loop conditions for the last two loops are incorrectly using `endingRow` and `startingCol` as row indices when filling the elements of the matrix.

Additionally, the decrement of `endingCol` before the second loop will skip the last column in the loop. The decrement of `endingRow` before the third loop and the increment of `startingCol` before the last loop will skip the last row and the first column in the respective loops.

Fix:
- Add an additional condition to each of the second and fourth loops to ensure they do not overwrite elements that have already been filled. 
- Remove the decrements of `endingCol` and `endingRow` and the increment of `startingCol` before the last loop.

New loop conditions:
```java
for (int i = startingCol; element <= total && i <= endingCol; i++) {
    matrix[startingRow][i] = element;
    element++;
}
startingRow++;

for (int i = startingRow; element <= total && i <= endingRow; i++) {
    matrix[i][endingCol] = element;
    element++;
}
endingCol--;

for (int i = endingCol; element <= total && i >= startingCol; i--) {
    matrix[endingRow][i] = element;
    element++;
}
endingRow--;

for (int i = endingRow; element <= total && i >= startingRow; i--) {
    matrix[i][startingCol] = element;
    element++;
}
startingCol++;
```

The code re-assigned `startingRow` to 1 and `endingRow` to 3 after the first and third loops which meant new elements would be written into that row and that column instead of the old ones being overwritten. Thus, the decrements of `endingRow` and `endingCol` and increment of `startingCol` should be removed. 

Fixed code:
```java
class Solution {
    public int[][] generateMatrix(int n) {
        int startingRow = 0;
        int endingRow = n - 1;
        int startingCol = 0;
        int endingCol = n - 1;

        int total = n * n;
        int element = 1;
        int[][] matrix = new int[n][n];

        while (element <= total) {

            for (int i = startingCol; element <= total && i <= endingCol; i++) {
                matrix[startingRow][i] = element;
                element++;
            }
            startingRow++;

            for (int i = startingRow; element <= total && i <= endingRow; i++) {
                matrix[i][endingCol] = element;
                element++;
            }
            endingRow--;

            for (int i = endingCol; element <= total && i >= startingCol; i--) {
                matrix[endingRow][i] = element;
                element++;
            }
            endingCol--;

            for (int i = endingRow; element <= total && i >= startingRow; i--) {
                matrix[i][startingCol] = element;
                element++;
            }
            startingCol++;
        }
        return matrix;
    }
}
```