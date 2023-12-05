```java
class Solution {
    public boolean validTicTacToe(String[] board) {
        int x = cntNumber('X', board);
        int o = cntNumber('O', board);
        if (x < o || x > o + 1) {
            return false;
        }
        if (o >= 3) {
            if (x == o && hasWon('X', board)) {
                return false;
            }
            if (x > o && hasWon('O', board)) {
                return false;
            }
        }
        return true;
    }

    private int cntNumber(char target, String[] board) {
        int res = 0;
        for (String s : board) {
            for (int j = 0; j < 3; j++) {
                if (target == s.charAt(j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean hasWon(char target, String[] board) {
        String toWin = Character.toString(target).repeat(3);
        for (String s : board) {
            if (s.equals(toWin)) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            boolean col = true;
            for (String s : board) {
                col = col && target == s.charAt(j);
                if (! col) {
                    break;
                }
            }
            if (col) {
                return true;
            }
        }
        if (target != board[1].charAt(1)) {
            return false;
        }

        if (target == board[0].charAt(0) && target == board[2].charAt(2)) {
            return true;
        }

        if (target == board[0].charAt(2) && target == board[2].charAt(0)) {
            return true;
        }
        return false;
    }
}
```