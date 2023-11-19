```java
// Runtime: 0 ms (Top 100.00%) | Memory: 42.1 MB (Top 73.63%)
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] next = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = nextState(board, i, j, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = next[i][j];
            }
        }
    }

    private int nextState(int[][] board, int row, int col, int m, int n) {
        int liveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == -1)) {
                    liveNeighbors++;
                }
            }
        }
        if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
            return -1;
        } else if (board[row][col] == 0 && liveNeighbors == 3) {
            return 1;
        } else {
            return board[row][col];
        }
    }
}
```