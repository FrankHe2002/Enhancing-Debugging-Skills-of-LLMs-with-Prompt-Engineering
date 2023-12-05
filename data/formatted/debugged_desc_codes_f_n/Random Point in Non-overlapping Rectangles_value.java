```java
import java.util.*;

class Solution {
    int[][] rects;
    TreeMap<Integer, Integer> weightedRectIndex = new TreeMap<>();
    int nPoints = 0;

    Random rng = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        int index = 0;
        for (int[] rect : rects) {
            weightedRectIndex.put(nPoints, index++);
            int width = Math.abs(rect[2] - rect[0]) + 1;
            int height = Math.abs(rect[3] - rect[1]) + 1;
            nPoints += width * height;
        }
    }

    public int[] pick() {
        int point = rng.nextInt(nPoints);
        var entry = weightedRectIndex.floorEntry(point);
        int rectPoint = point - entry.getKey();
        int[] rect = rects[entry.getValue()];
        int width = Math.abs(rect[2] - rect[0]) + 1;
        return new int[] {
            rect[0] + (rectPoint % width),
            rect[1] + (rectPoint / width)
        };
    }
}
```