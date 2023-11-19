class Solution {
    public int minimumMoves(int[][] grid) {

        int n = grid.length;
        Set<Position> set = new HashSet<>();

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0, 0, 0, 1));
        int count = 0;

        if (grid[n - 1][n - 2] == 1 || grid[n - 1][n - 1] == 1)
            return - 1;

        while (! q.isEmpty()) {
            ++ count;
            Queue<Position> nextq = new LinkedList<>();
            while (! q.isEmpty()) {

                Position p = q.poll();

                int r1 = p.getr1();
                int r2 = p.getr2();
                int c1 = p.getc1();
                int c2 = p.getc2();

                if (r1 == n - 1 && r2 == n - 1 && c1 == n - 2 && c2 == n - 1)
                    return count - 1;

                if (set.contains(p))
                    continue;

                if (c1 + 1 < n && grid[r1][c1 + 1] != 1 && c2 + 1 < n && grid[r2][c2 + 1] != 1)
                    nextq.offer(new Position(r1, c1 + 1, r2, c2 + 1));
                if (r1 + 1 < n && grid[r1 + 1][c1] != 1 && r2 + 1 < n && grid[r2 + 1][c2] != 1)
                    nextq.offer(new Position(r1 + 1, c1, r2 + 1, c2));

                if (r1 == r2 && r1 + 1 < n && r2 + 1 < n && grid[r1 + 1][c1] == 0 && grid[r2 + 1][c2] == 0 && grid[r1 + 1][c1] == 0)
                    nextq.offer(new Position(r1, c1, r1 + 1, c1));
                