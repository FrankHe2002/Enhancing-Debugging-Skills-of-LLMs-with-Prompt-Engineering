```java
// Runtime: 177 ms (Top 52.16-) | Memory: 42.7 MB (Top 24.25%)
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean is = isexist(i, j, board, vis, 1, word);
                    if (is) return true;
                }
            }
        }
        return false;
    }

    static int dir[][] = {{1, 0}, {0, 1}, {- 1, 0}, {0, - 1}};

    static boolean isexist(int r, int c, char board[][], boolean vis[][],
                           int idx, String word) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || idx >= word.length() ||
            vis[r][c] || board[r][c] != word.charAt(idx)) return false;
        
        vis[r][c] = true;
        
        for (int k = 0; k < 4; k++) {
            int rd = r + dir[k][0];
            int cd = c + dir[k][1];
            boolean is = isexist(rd, cd, board, vis, idx + 1, word);
            if (is) return true;
        }
        
        vis[r][c] = false;
        return idx == word.length() - 1;
    }
}
```