import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    private static final int[][] DIR = new int[][] {
            {1, 0}, {- 1, 0}, {0, 1}, {0, - 1}
    };

    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;

        while (true) {
            PriorityQueue<Region> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.uninfected.size()));
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] != 1 || visited[i][j])
                        continue;
                    Region reg = new Region();
                    dfs(i, j, reg, isInfected, visited, new boolean[m][n], m, n);
                    if (reg.uninfected.size() != 0)
                        pq.offer(reg);
                }
            }
            if (pq.isEmpty())
                break;
            Region containReg = pq.poll();
            ans += containReg.wallsRequired;
            for (int[] cell : containReg.infected)
                isInfected[cell[0]][cell[1]] = 2;
            while (! pq.isEmpty()) {
                Region spreadReg = pq.poll();

                for (int[] cell : spreadReg.uninfected)
                    isInfected[cell[0]][cell[1]] = 1;
            }