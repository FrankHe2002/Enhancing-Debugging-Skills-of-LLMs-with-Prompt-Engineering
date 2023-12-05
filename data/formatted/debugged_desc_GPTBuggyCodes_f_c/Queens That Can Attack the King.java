```java
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int r = king[0];
        int l = king[1];
        int[][] board = new int[8][8];
        int n = 8;

        for (int i = 0; i < queens.length; i++) {
            int row = queens[i][0];
            int column = queens[i][1];
            board[row][column] = 1;
        }
        for (int j = l; j <= n; j++) {
            if (board[r][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(r, j)));
                break;
            }
        }

        for (int i = r; i < n; i++) {
            if (board[i][l] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, l)));
                break;
            }
        }

        for (int i = r; i >= 0; i--) {
            if (board[i][l] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, l)));
                break;
            }
        }

        for (int j = l; j >= 0; j--) {
            if (board[r][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(r, j)));
                break;
            }
        }

        for (int i = r, j = l; i >= 0 && j >= 0; j--, i--) {
            if (board[i][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }

        for (int i = r, j = l; j < n && i >= 0; j++, i--) {
            if (board[i][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }

        for (int i = r, j = l; i < n && j < n; j++, i++) {
            if (board[i][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }

        for (int i = r, j = l; j >= 0 && i < n; j--, i++) {
            if (board[i][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }

        return res;
    }
}
```