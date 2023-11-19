Bug type: ArrayIndexOutOfBoundsException

Reasoning: The buggy code causes an `ArrayIndexOutOfBoundsException` in the line `if (visited[-1][y] || maze[x][y] == '+') continue;`. The `-1` index is out of bounds for the `visited` array. The correct check should be `visited[x][y]`. 

Fix:
```java
// Runtime: 8 ms (Top 87.01%) | Memory: 43.7 MB (Top 91.43%)
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length, queueSize;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[] curr;
        int[][] dirs = {{0, 1}, {0, - 1}, {1, 0}, {- 1, 0}};
        int x, y, steps = 0;

        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;

        while (! queue.isEmpty()) {
            queueSize = queue.size();
            steps++;

            for (int i = 0; i < queueSize; i++) {
                curr = queue.poll();

                for (int[] dir : dirs) {
                    x = dir[0] + curr[0];
                    y = dir[1] + curr[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
                    if (visited[x][y] || maze[x][y] == '+') continue;

                    // check if we have reached boundary
                    if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) return steps;

                    queue.offer(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }

        return - 1;
    }
}
```