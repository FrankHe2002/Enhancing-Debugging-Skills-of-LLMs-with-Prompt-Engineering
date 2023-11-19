The bug in the provided code is that it is missing the declaration and initialization of the `HashSet` named `seen`. This causes a compilation error. 
To fix the bug, we need to declare and initialize the `HashSet` before the outer for loop.

Fixed Code:
```java
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char currentVal = board[i][j];
                    if (!(seen.add(currentVal + " found in row " + i)) ||
                            !(seen.add(currentVal + " found in column " + j)) ||
                            !(seen.add(currentVal + " found in sub box " + i / 3 + "-" + j / 3)))
                        return false;
                }
            }
        }
        return true;
    }
}
```