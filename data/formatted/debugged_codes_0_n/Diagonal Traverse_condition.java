class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Input matrix is null");
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int r = 0;
        int c = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (c == cols - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == rows - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }

        return result;
    }
}