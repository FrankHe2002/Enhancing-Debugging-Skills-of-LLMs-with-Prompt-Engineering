Fixed Code:
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
        int liveNeighbors = countLiveNeighbors(board, row, col, m, n);
        if (board[row][col] == 1) {
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (liveNeighbors == 3) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col, int m, int n) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidCell(i, j, m, n) && !(i == row && j == col) && board[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValidCell(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
```