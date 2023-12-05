Bug Type:
Logic error

Reasoning:
The original code has incorrect boundary check conditions and an incorrect condition for wall cells (+). The boundary checks are off by one, and the condition for checking whether the cell is a wall is incorrect. 

Fix:
Updated the boundary check conditions and corrected the condition for checking wall cells to reflect the correct intended logic.

Fixed Code:
```java
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length, queueSize;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[] curr;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int x, y, steps = 0;

        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            queueSize = queue.size();
            steps++;

            for (int i = 0; i < queueSize; i++) {
                curr = queue.poll();

                for (int[] dir : dirs) {
                    x = dir[0] + curr[0];
                    y = dir[1] + curr[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols || (x == entrance[0] && y == entrance[1])) continue;
                    if (maze[x][y] == '+') continue;

                    // check if we have reached boundary
                    if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) return steps;

                    queue.offer(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }

        return -1;
    }
}
```