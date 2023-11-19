class Solution {
    boolean isClosed = true;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j + 1] == 'O' && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = 'T';

        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }
}