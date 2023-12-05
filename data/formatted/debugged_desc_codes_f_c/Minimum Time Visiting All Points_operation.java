The bug in the provided Java code is that the nested for loops iterating through the points array are directly using the points[i] and points[j] coordinates, which are incorrect.

To fix this issue, we need to iterate through the coordinates for each point correctly.

Here's the fixed code:
```java
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x = Math.abs(points[i][0] - points[i + 1][0]);
            int y = Math.abs(points[i][1] - points[i + 1][1]);
            max += Math.max(x, y);
        }
        return max;
    }
}
```