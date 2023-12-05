Issues/bugs identified:
1. The if condition `if (visited[-1][y] || maze[x][y] == '+') continue;` might lead to an error. It seems like it should be `if (visited[x][y] || maze[x][y] == '+') continue;`.
2. The while loop logic might not be handling the boundary cases correctly. It should check if the current cell is the entrance itself or if the current cell is on the boundary, then return the steps.

Here are the steps for fixing the bugs:
1. Update the condition inside the for loop to `if (visited[x][y] || maze[x][y] == '+') continue;`.
2. Before the inner for loop, add a check to avoid returning the steps if the current cell is the entrance itself. After the inner for loop, add a check to see if the current cell is on the boundary and then return the steps.

Here's the updated code:

```java
import java.util.LinkedList;
import java.util.Queue;

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

        while (!queue.isEmpty()) {
            queueSize = queue.size();
            steps++;

            for (int i = 0; i < queueSize; i++) {
                curr = queue.poll();

                if (curr[0] != entrance[0] || curr[1] != entrance[1]) {
                    for (int[] dir : dirs) {
                        x = dir[0] + curr[0];
                        y = dir[1] + curr[1];

                        if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
                        if (visited[x][y] || maze[x][y] == '+') continue;

                        if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) return steps;

                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                } else {
                    if (curr[0] == 0 || curr[0] == rows - 1 || curr[1] == 0 || curr[1] == cols - 1) return steps;
                }
            }
        }

        return -1;
    }
}
```