The bug in the code seems to be related to the index variable `i` in the while loops. It is initialized to -1, but it should start from 0 to iterate through the `intervals` array.

Here's the fixed code:

```java
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;

        List<int[]> merged = new LinkedList<>();
        int i = 0; // Changed initialization to 0
        // add not overlapping
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }
        // add overlapping
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);
        // add rest
        while (i < intervals.length) {
            merged.add(intervals[i]);
            i++;
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
```