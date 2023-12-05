```java
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int n = 8;

        int[][] board = new int[n][n];
        for (int i = 0; i < queens.length; i++) {
            int row = queens[i][0];
            int column = queens[i][1];
            board[row][column] = 1;
        }

        int[] directions = new int[] {-1, 0, 1, -1, 0, -1, 1, 0, 1, 1, -1, -1, -1, 1, 1, -1};
        for (int i = 0; i < directions.length; i += 2) {
            int dx = directions[i];
            int dy = directions[i + 1];

            int x = king[0];
            int y = king[1];

            while (x >= 0 && x < n && y >= 0 && y < n) {
                if (board[x][y] == 1) {
                    res.add(Arrays.asList(x, y));
                    break;
                }
                x += dx;
                y += dy;
            }
        }

        return res;
    }
}
```