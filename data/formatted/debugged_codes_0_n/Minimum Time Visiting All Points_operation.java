```java
// Runtime: 2 ms (Top 57.50*) | Memory: 43.4 MB (Top 57.64%)
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int max = 0, x, y;
        for (int i = 0; i < points.length - 1; i++) {
            x = Math.abs(points[i][0] - points[i + 1][0]);
            y = Math.abs(points[i][1] - points[i + 1][1]);
            max += Math.max(x, y);
        }
        return max;
    }
}
```