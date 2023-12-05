```java
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

    private int nextState(int[][] board, int i, int j, int m, int n) {
        int liveNeighbors = 0;
        for (int x = Math.max(0, i - 1); x < Math.min(m, i + 2); x++) {
            for (int y = Math.max(0, j - 1); y < Math.min(n, j + 2); y++) {
                if (x == i && y == j) {
                    continue;
                }
                liveNeighbors += board[x][y] & 1;
            }
        }
        if ((board[i][j] & 1) > 0) {
            return liveNeighbors < 2 || liveNeighbors > 3 ? 0 : 1;
        } else {
            return liveNeighbors == 3 ? 1 : 0;
        }
    }
}
```