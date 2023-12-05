```java
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0, count = 0;
        for (int i = 0; i < rectangles.length; i++) {
            // Calculate the side length of each rectangle
            int len = Math.min(rectangles[i][0], rectangles[i][1]);
            // Update the maximum side length
            max = Math.max(max, len);
        }
        // Count the rectangles that can form a square with a side length of maxLen
        for (int i = 0; i < rectangles.length; i++) {
            if (Math.min(rectangles[i][0], rectangles[i][1]) == max) {
                count++;
            }
        }
        return count;
    }
}
```