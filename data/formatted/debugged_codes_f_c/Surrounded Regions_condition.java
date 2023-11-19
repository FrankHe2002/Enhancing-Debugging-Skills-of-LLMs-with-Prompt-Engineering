Bug Type: Array Index Out Of Bounds

Reasoning: The bug occurs in the `dfs` method where the condition `j > 0` in the if statement is incorrect. The intention is to check if `j` is less than 0, indicating an out-of-bounds index. However, the condition is mistakenly written as `j > 0`, which allows the code to access indices greater than or equal to `0` without throwing an exception. This bug can cause the program to access elements outside the bounds of the 2D array.

Fix: Change the condition from `j > 0` to `j < 0` in the if statement of the `dfs` method to correctly identify if `j` is less than 0 and out of bounds.

```java
class Solution {
    boolean isClosed = true;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // To identify all those O which are adjacent and unbounded by 'X', we put a temporary value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    dfs(board, i, j);
                }
            }
        }

        // revert the temperoray value and also replace remaining O with X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = 'T'; // to put a temperory mark/ to mark as visited

        dfs(board, i, j + 1); // Top
        dfs(board, i, j - 1); // Bottom
        dfs(board, i +