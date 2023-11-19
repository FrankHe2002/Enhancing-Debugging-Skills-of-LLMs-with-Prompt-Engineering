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
=======
        int x = a[0].length - 1;
        int i, j;
        while (x-- > 0)
            for (i = 0; i < a.length; i++)
                if (a[i][x] > a[(j = (x + 1)) % a.length][x + 1])
                    a[j][--x = x < 0 ? a.length - 1 : x] += a[i][x]--;
                else
                    a[i][x]--;
        i = a[1][j = x = 0];
    }