```java
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] arr = new int[n][n];
        int[][] dpTop = new int[n][n];
        int[][] dpLeft = new int[n][n];
        int[][] dpRight = new int[n][n];
        int[][] dpBottom = new int[n][n];
        int maxPlusSignLength = 0;

        for (int[] subArray : arr) {
            Arrays.fill(subArray, 1);
        }

        for (int i = 0; i < mines.length; i++) {
            arr[mines[i][0]][mines[i][1]] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && arr[i - 1][j] == 1) {
                    dpTop[i][j] = 1 + dpTop[i - 1][j];
                }

                if (j - 1 >= 0 && arr[i][j - 1] == 1) {
                    dpLeft[i][j] = 1 + dpLeft[i][j - 1];
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < n && arr[i + 1][j] == 1) {
                    dpBottom[i][j] = 1 + dpBottom[i + 1][j];
                }

                if (j + 1 < n && arr[i][j + 1] == 1) {
                    dpRight[i][j] = 1 + dpRight[i][j + 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) continue;
                int minAdjacentOnes = Math.min(Math.min(dpTop[i][j], dpBottom[i][j]), Math.min(dpLeft[i][j], dpRight[i][j]));
                maxPlusSignLength = Math.max(maxPlusSignLength, minAdjacentOnes +