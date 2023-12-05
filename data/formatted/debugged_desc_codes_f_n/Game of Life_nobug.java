```java
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countLiveNeighbors(board, i, j, m, n);
                if (board[i][j] == 0) {
                    board[i][j] = (count == 3) ? 2 : 0;
                } else {
                    board[i][j] = (count < 2 || count > 3) ? 3 : 1;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }

    public int countLiveNeighbors(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                int a = i + x, b = j + y;
                if (a >= 0 && a < m && b >= 0 && b < n) {
                    count += (board[a][b] == 1 || board[a][b] == 3) ? 1 : 0;
                }
            }
        }
        return count;
    }
}
```