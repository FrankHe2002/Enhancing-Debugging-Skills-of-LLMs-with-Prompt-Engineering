```java
// Runtime: 7 ms (Top 32.30%) | Memory: 42.2 MB (Top 39.46%)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        final int rows = grid.length;
        final int cols = grid[0].length;
        final int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[rows][cols];
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j])
                    continue;
                if (grid[i][j] != 1)
                    continue;
                int count = 0;
                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {i, j});
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int row = curr[0];
                    int col = curr[1];
                    count++;
                    for (int[] dir : directions) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];
                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                                && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                            visited[newRow][newCol] = true;
                            queue.offer(new int[] {newRow, newCol});
                        }
                    }
                }
                res = Math.max(res, count);
            }
        }

        return res;

    }
}
```