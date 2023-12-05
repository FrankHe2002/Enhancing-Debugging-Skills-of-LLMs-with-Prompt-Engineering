Fix:

```java
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0, count = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int len = Math.min(rectangles[i][0], rectangles[i][1]);
            if (len > max) {
                max = len;
                count = 1;
            } else if (len == max) {
                count++;
            }
        }
        return count;
    }
}
```