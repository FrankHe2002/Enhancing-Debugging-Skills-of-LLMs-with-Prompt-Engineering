```java
import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // change the sorting order to ascending

        int start = intervals[0][0];
        int end = intervals[0][1];
        int res = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] >= end) {
                start = interval[0];
                end = interval[1];
            } else {
                res++;
            }
        }

        return res;
    }
}
```