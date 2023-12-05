```java
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, ans = 0;
        for (int k = 0; k < n - 1; k++) {
            int fittingRow = -1; // looking for the fitting row for row k
            for (int i = k; i < n; i++) {
                boolean validRow = true;
                for (int j = k + 1; j < n; j++) {
                    if (grid[i][j] == 1) {
                        validRow = false;
                        break;
                    }
                }
                if (validRow) {
                    fittingRow = i;
                    break;
                }
            }
            if (fittingRow == -1) {
                return -1; // did not find a fitting row, return -1
            }
            for (int m = fittingRow; m > k; m--) {
                int[] temp = grid[m];
                grid[m] = grid[m - 1];
                grid[m - 1] = temp;
                ans++;
            }
        }
        return ans;
    }
}
```