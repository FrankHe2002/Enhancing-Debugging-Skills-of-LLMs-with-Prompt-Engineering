Bug type: Off-by-one error

Reasoning: 
In the constructor of the `Solution` class, the cumulative weight for each rectangle is calculated and stored in the `weightedRectIndex` `TreeMap`. The cumulative weight is used to associate a rectangle index with a range of points. However, there is an off-by-one error when computing the `nPoints` value, which represents the total weight. The `nPoints` value should be initialized as 1 (representing the first point), and the cumulative weight should be incremented by `width(rect) * height(rect)` in each iteration.

To fix this bug, the `nPoints` initialization should be changed to `int nPoints = 1;` and the increment in the loop should be `nPoints += width(rect) * height(rect);`.

Fixed code:
```java
import java.util.Random;
import java.util.TreeMap;

class Solution {

    int[][] rects;
    TreeMap<Integer, Integer> weightedRectIndex = new TreeMap<>();
    int nPoints = 1;

    Random rng = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        int index = 0;
        for (int[] rect : rects) {
            // inserts cumulative weight key pointing to rectangle index
            weightedRectIndex.put(nPoints, index++);
            nPoints += width(rect) * height(rect);
        }
    }

    public int[] pick() {
        // generates random point within total weight
        int point = rng.nextInt(nPoints);
        // finds appropriate rectangle
        var entry = weightedRectIndex.floorEntry(point);
        // find point within the current rectangle
        int rectPoint = point - entry.getKey();
        int[] rect = rects[entry.getValue()];
        return new int[] {
                rect[0] + rectPoint % width(rect),
                rect[1] + rectPoint / width(rect)};
    }

    private int width(int[] rect) {
        return rect[2] - rect[0] + 2;
    }

    private int height(int[] rect) {
        return rect[3] - rect[1] + 1;
    }
}
```