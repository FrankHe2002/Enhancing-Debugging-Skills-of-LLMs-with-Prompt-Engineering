The bug is in the logic of the `eraseOverlapIntervals` method. The issue is that the method does not properly track the overlapping intervals and determine the minimum number of intervals to be removed.
The fix involves creating a variable to track the end point of each interval and then updating that variable based on the comparison of current and previous intervals.

Fix:
```java
import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int end = intervals[0][1];
        int count = 1;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        
        return intervals.length - count;
    }
}
```
This fix sorts the intervals based on their end points, allows non-overlapping intervals to pass, and counts the minimum number of intervals needed to be removed to make the rest of the intervals non-overlapping.