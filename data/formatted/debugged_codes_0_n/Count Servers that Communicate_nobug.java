```java
// Runtime: 6 ms (Top 99.66%) | Memory: 39.7 MB (Top 18.10%)
class Solution {
    int[] parent;
    int[] rank;

    public int countServers(int[][] grid) {
        parent = new int[grid.length * grid[0].length];
        rank = new int[grid.length * grid[0].length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    check(i, j, grid);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int box = i * grid[0].length + j;
                    if (parent[box] == box && rank[box] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void check(int sr, int sc, int[][] grid) {
        int mbox = sr * grid[0].length + sc;
        for (int i = sr; i < grid.length; i++) {
            if (grid[i][sc] == 1) {
                int cbox = i * grid[0].length + sc;
                int xl = find(mbox);
                int yl = find(cbox);
                if (xl != yl) {
                    union(xl, yl);
                }
            }
        }
        for (int j = sc; j < grid[0].length; j++) {
            if (grid[sr][j] == 1) {
                int cbox = sr * grid[0].length + j;
                int xl = find(mbox);
                int yl = find(cbox);
                if (xl != yl) {
                    union(xl, yl);
                }
            }
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return