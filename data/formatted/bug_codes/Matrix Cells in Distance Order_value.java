class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int[][] res = new int[rows * cols][2];

        int idx = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[idx][0] = i;
                res[idx][1] = j;
                idx++;
            }
        }

        Arrays.sort(res, (a, b) -> {
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);

            return d1 - d2;
        });

        return res;
    }
}

