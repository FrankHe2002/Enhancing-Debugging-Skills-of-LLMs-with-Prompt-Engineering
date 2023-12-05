```java
class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int M = (int) 1e9 + 7;
        int m = board.size();
        int n = board.get(0).length();
        int[][] dp = new int[m][n];
        int[][] ways = new int[m][n];
        ways[m - 1][n - 1] = 1; // base case.
        int[][] dirs = {{-1, 0}, {0, -1}, {-1, -1}}; // all 3 ways where we can travel.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X' || (i == m - 1 && j == n - 1)) {
                    continue;
                }
                int cur = Character.isDigit(board.get(i).charAt(j)) ? board.get(i).charAt(j) - '0' : 0;
                for (int[] d : dirs) {
                    int x = d[0] + i;
                    int y = d[1] + j;
                    if (x < 0 || y < 0 || ways[x][y] == 0) {
                        continue;
                    }
                    int newDP = cur + dp[x][y];
                    if (newDP > dp[i][j]) {
                        dp[i][j] = newDP;
                        ways[i][j] = ways[x][y];
                    } else if (newDP == dp[i][j]){
                        ways[i][j] = (ways[i][j] + ways[x][y]) % M;
                    }
                }
            }
        }
        return new int[]{dp[0][0] == 0 ? 0 : dp[0][0], ways[0][0]};
    }
}
```