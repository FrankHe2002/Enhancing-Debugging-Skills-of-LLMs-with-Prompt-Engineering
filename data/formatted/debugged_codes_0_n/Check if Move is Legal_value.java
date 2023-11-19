class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {

        int[][] direction = {{1, 0}, {- 1, 0}, {0, 1}, {0, - 1}, {1, 1}, {- 1, - 1}, {1, - 1}, {- 1, 1}};

        for (int[] d : direction) {
            if (dfs(board, rMove, cMove, color, d, 1))
                return true;
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, char color, int[] direction, int len) {

        int nr = r + direction[0];
        int nc = c + direction[1];

        if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length) return false;

        if (board[nr][nc] == color) {
            if (len >= 3) return true;
            else
                return false;
        } else {
            if (board[nr][nc] == '.') {
                return false;
            }
            return dfs(board, nr, nc, color, direction, len + 1);
        }
    }
}