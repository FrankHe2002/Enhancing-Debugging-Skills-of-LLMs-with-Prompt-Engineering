Bug: Incorrect Area Calculation

Explanation:
In the `computeArea` method, the calculation of the total area covered by the two rectangles is incorrect. The original calculation simply adds the areas of both rectangles without taking the overlapping region into account. The total area should be the sum of the area of both rectangles minus the overlapping area.

Fix:
```java
// Runtime: 5 ms (Top 35.02%) | Memory: 42.9 MB (Top 64.28%)
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x1 = Math.max(ax1, bx1);
        int y1 = Math.max(ay1, by1);
        int x2 = Math.min(ax2, bx2);
        int y2 = Math.min(ay2, by2);

        int area = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);

        if (x2 > x1 && y2 > y1) {
            int overlap = (x2 - x1) * (y2 - y1);
            area -= overlap;
        }

        return area;
    }
}
```