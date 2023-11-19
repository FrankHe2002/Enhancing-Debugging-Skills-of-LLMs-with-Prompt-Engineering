class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = calculate(grid, i, j);
            }
        }
        return res;
    }

    int calculate(int[][] arr, int i, int j) {
        int r1 = i;
        int r2 = i;
        int c1 = j;
        int c2 = j;

        HashSet<Integer> hs1 = new HashSet<Integer>();
        HashSet<Integer> hs2 = new HashSet<Integer>();

        while (r1 > 0 && c1 > 0) {
            hs1.add(arr[-- r1][-- c1]);
        }

        while (r2 < arr.length - 1 && c2 < arr[0].length - 1) {
            hs2.add(arr[++ r2][++ c2]);
        }
        return Math.abs(hs1.size() - hs2.size());
    }
}