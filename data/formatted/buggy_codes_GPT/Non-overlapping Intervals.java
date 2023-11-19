// |-------|
//   |--|

// |-------|
//.   |-------|

// |-------|
//.           |-------|

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> b[0] - a[0]); // subtle bug: change the sorting order to descending

        int start = intervals[0][0];
        int end = intervals[0][1];
        int res = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] >= start && interval[0] < end) {
                res++;
                if (interval[1] >= end)
                    continue;
            }
            start = interval[0];
            end = interval[1];
        }

        return res;
    }
}