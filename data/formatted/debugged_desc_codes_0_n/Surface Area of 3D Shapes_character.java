```java
// Runtime: 4 ms (Top 63.77%) | Memory: 44.7 MB (Top 34.78%)
class Solution {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Adding the top part of grid
                area += Math.max(0, grid[i][j] - (i > 0 ? grid[i - 1][j] : 0));

                // Adding the left part of grid
                area += Math.max(0, grid[i][j] - (j > 0 ? grid[i][j - 1] : 0));

                // Adding bottom part of bottom-most cubes
                if (i == n - 1) area += grid[i][j];

                // Adding right part for right-most cubes
                if (j == n - 1) area += grid[i][j];

                // Add top and bottom surfaces if there is no hole in grid
                if (grid[i][j] != 0) area += 2;
            }
        }
        return area;
    }
}
```