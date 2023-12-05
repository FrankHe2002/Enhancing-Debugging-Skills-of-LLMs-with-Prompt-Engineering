The provided buggy Java code starts with a wrong condition that leads to the wrong solution. To correct the condition, use the formula to check if any point within the given rectangle falls within the circle. 
The original condition doesn't fit in this use case as it calculates the distance only with the centre points.

```java
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = clamp(xCenter, x1, x2);
        int closestY = clamp(yCenter, y1, y2);
        
        int distanceX = xCenter - closestX;
        int distanceY = yCenter - closestY;
        
        return (distanceX * distanceX) + (distanceY * distanceY) <= (radius * radius);
    }
    
    private int clamp(int x, int x1, int x2) {
        return Math.max(x1, Math.min(x2, x));
    }
}
```