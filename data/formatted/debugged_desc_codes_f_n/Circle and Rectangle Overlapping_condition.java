```java
// Runtime: 1 ms (Top 38.18%) | Memory: 41.1 MB (Top 21.82%)
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return Math.pow(Math.max(x1 - xCenter, 0), 2)
                + Math.pow(Math.max(y1 - yCenter, 0), 2) <= radius * radius
            || Math.pow(Math.min(x2 - xCenter, 0), 2)
                + Math.pow(Math.max(y1 - yCenter, 0), 2) <= radius * radius
            || Math.pow(Math.min(x2 - xCenter, 0), 2)
                + Math.pow(Math.min(y2 -yCenter, 0), 2) <= radius * radius
            || Math.pow(Math.max(x1 - xCenter, 0), 2)
                + Math.pow(Math.min(y2 - yCenter, 0), 2) <= radius * radius;
    }
}
```