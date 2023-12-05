```java
// Runtime: 4 ms (Top 10.56%) | Memory: 44.7 MB (Top 26.11%)
class Solution {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    result++;
                }
            }
        }
        return result;
    }
}
```