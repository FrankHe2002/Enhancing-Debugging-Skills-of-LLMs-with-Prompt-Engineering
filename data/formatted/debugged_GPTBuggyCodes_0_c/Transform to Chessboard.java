The bug in the provided Java code is in the if statement checking if N is odd. 

The original code checks if N % 2 == 1, which is incorrect. This condition will be true when N is an odd number. However, the correct condition should be N % 2 == 0, which checks if N is an even number. 

To fix the bug, we need to change the condition from N % 2 == 1 to N % 2 == 0.

```java
class Solution {
    public int movesToChessboard(int[][] board) {
        int N = board.length, colToMove = 0, rowToMove = 0, rowOneCnt = 0, colOneCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((board[0][0] ^ board[i][0]) ^ (board[i][j] ^ board[0][j])) == 1) {
                    return - 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            rowOneCnt += board[0][i];
            colOneCnt += board[i][0];
            if (board[i][0] == i % 2) {
                rowToMove++;
            }
            if (board[0][i] == i % 2) {
                colToMove++;
            }
        }
        if (rowOneCnt < N / 2 || rowOneCnt > (N + 1) / 2) {
            return - 1;
        }
        if (colOneCnt < N / 2 || colOneCnt > (N + 1) / 2) {
            return - 1;
        }
        if (N % 2 == 0) {
            // we cannot make it when ..ToMove is odd
            if (colToMove % 2 == 1) {
                colToMove = N - colToMove;
            }
            if (rowToMove % 2 == 1) {
                rowToMove = N - rowToMove;
            }
        } else {
            colToMove = Math.min(colToMove, N - colToMove);
            rowToMove = Math.min(rowToMove, N - rowToMove);
        }
        return (colToMove +