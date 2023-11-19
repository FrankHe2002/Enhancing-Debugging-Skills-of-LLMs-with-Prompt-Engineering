class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] arr = new int[n][n];
        for (int[] subArray : arr) {
            Arrays.fill(subArray, 1);
        }

        for (int i = 0; i < mines.length; i++) {
            arr[mines[i][0]][mines[i][1]] = 0;
        }
        int[][] dpTop = new int[arr.length][arr.length];
        int[][] dpLeft = new int[arr.length][arr.length];
        int[][] dpRight = new int[arr.length][arr.length];
        int[][] dpBottom = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i - 1 >= 0 && arr[i - 1][j] == 1) {
                    dpTop[i][j] = 1 + dpTop[i - 1][j];
                }

                if (j - 1 >= 0 && arr[i][j - 1] == 1) {
                    dpLeft[i][j] = 1 + dpLeft[i][j - 1];
                }
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (i + 1 < arr.length && arr[i + 1][j] == 1) {
                    dpBottom[i][j] = 1 + dpBottom[i + 1][j];
                }

                if (j + 1 < arr.length && arr[i][j + 1] == 1) {
                    dpRight[i][j] = 1 + dpRight[i][j + 1];
                }
            }
        }

        int maxPlusSignLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) continue;
                int minAdjacentOnes = Math.min(Math.min(dpTop[i][j], dpBottom[i][j]), Math.min(dpLeft[i][j], dpRight[i][j]));
                maxPlusSignLength = Math.max(maxPlusSignLength, minAdjacentOnes + 1);
            }
        }

        return maxPlusSignLength;
    }
}