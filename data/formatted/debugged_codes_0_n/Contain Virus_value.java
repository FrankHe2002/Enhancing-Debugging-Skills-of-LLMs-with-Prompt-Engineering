```java
import java.util.*;

class Solution {

    private static final int[][] DIR = new int[][] {
            {1, 0}, {- 1, 0}, {0, 1}, {0, - 1}
    };

    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;

        while (true) {
            // infected regions, sorted desc according to the number of nearby 
            // uninfected nodes
            PriorityQueue<Region> pq = new PriorityQueue<Region>();
            // already visited cells
            boolean[][] visited = new boolean[m][n];

            // find regions
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // if current cell is infected, and it's not visited
                    if (isInfected[i][j] != 1 || visited[i][j])
                        continue;

                    // we found a new region, dfs to find all the infected
                    // and uninfected cells in the current region
                    Region reg = new Region();
                    dfs(i, j, reg, isInfected, visited, new boolean[m][n], m, n);

                    // if there are some uninfected nodes in this region, 
                    // we can contain it, so add it to priority queue
                    if (reg.uninfected.size() != 0)
                        pq.offer(reg);
                }
            }

            // if there are no regions to contain, break
            if (pq.isEmpty())
                break;

            // Contain region with most uninfected nodes
            Region containReg = pq.poll();
            ans += containReg.wallsRequired;

            // use (4) to mark a cell as contained
            for (int[] cell : containReg.infected)
                isInfected[cell[0]][cell[1]] = 2;

            // Spread infection to uninfected nodes in other regions
            while (! pq.isEmpty()) {
                Region spreadReg = pq.poll();

                for (int[] cell : spreadReg.uninfected)
                    isInfected[cell[0]][cell[1]] = 1;
            }
        }
        return ans;
    }

    private void dfs(int i, int j, Region reg, int[][] grid, boolean[][] visited, boolean[][] uninfected