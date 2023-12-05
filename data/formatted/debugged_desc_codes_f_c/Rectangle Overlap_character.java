The given code is checking for the incorrect conditions to determine if two rectangles overlap. The conditions are inverted, resulting in the incorrect output. 

The correct approach to checking if two rectangles overlap is to check if one rectangle's left edge is to the right of the other's right edge, or if one rectangle's right edge is to the left of the other's left edge, or if one rectangle's bottom edge is above the other's top edge, or if one rectangle's top edge is below the other's bottom edge. If any of these conditions are true, the rectangles do not overlap. Using De Morgan's law, these can be combined to accurately check for the overlap using the condition `return !(x1 >= x4 || x2 <= x3 || y1 >= y4 || y2 <= y3);`. 

The corrected code is as follows:

```java
// Rectangle Overlap
// https://leetcode.com/problems/rectangle-overlap/

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];
        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];
        return !(x1 >= x4 || x2 <= x3 || y1 >= y4 || y2 <= y3);
    }
}
```