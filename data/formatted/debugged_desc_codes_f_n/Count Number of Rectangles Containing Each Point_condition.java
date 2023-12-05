```java
// Runtime: 1094 ms (Top 10.04%) | Memory: 110.7 MB (Top 25.95%)
class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] li = new int[rectangles.length];
        int[] hi = new int[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            li[i] = rectangles[i][0];
            hi[i] = rectangles[i][1];
        }

        int[] count = new int[points.length];
        for (int j = 0; j < points.length; j++) {
            int x = points[j][0];
            int y = points[j][1];
            for (int k = 0; k < rectangles.length; k++) {
                if (x >= 0 && x <= li[k] && y >= 0 && y <= hi[k]) {
                    count[j]++;
                }
            }
        }
        return count;
    }
}
```