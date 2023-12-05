```java
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, count = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int sideLen = Math.min(rectangles[i][0], rectangles[i][1]);
            if (sideLen > maxLen) {
                maxLen = sideLen;
                count = 1;
            } else if (sideLen == maxLen) {
                count++;
            }
        }
        return count;
    }
}
```