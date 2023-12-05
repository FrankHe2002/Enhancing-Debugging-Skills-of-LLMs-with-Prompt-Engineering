```java
// Runtime: 48 ms (Top 45.59%) | Memory: 42 MB (Top 92.59%)
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return n;
        int result = 0;
        for (int i = 0; i < n; i++) { // Change i >= n to i < n for correct loop condition
            for (int j = i + 1; j < n; j++) {
                result = Math.max(result, getPoints(i, j, points));
            }
        }
        return result;
    }

    private int getPoints(int pt1, int pt2, int[][] points) {
        int[] point1 = points[pt1], point2 = points[pt2];
        if (point1[0] == point2[0]) { // Check for infinite slope/floating point calculation errors
            // If the x-coordinates are the same, we only need to check if the x-coordinates of other points are the same
            int result = 0;
            for (int i = 0; i < points.length; i++) {
                if (points[i][0] == point1[0]) {
                    result++;
                }
            }
            return result;
        }
        double slope = (point1[1] - point2[1]) / (double) (point1[0] - point2[0]);
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            if ((points[i][0] == point1[0] && points[i][1] == point1[1]) ||
                    (point1[0] == points[i][0] && point1[1] != points[i][1])) { // Adjusted condition for the same x-coordinate
                result++;
            } else if ((double) (point1[1] - points[i][1]) / (double) (point1[0] - points[i][0]) == slope) {
                result++;
            }
        }
        return result;
    }
}
```