The bug in the code is in the `findRightInterval` method. When putting the intervals into the map, there is a typo in the `map.put` method and the index `length` is used instead of `i`. Also, the binary search method does not handle the case when the target is greater than the last element in the sorted array. 

Here's the fixed code:

```java
import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int intervalIndex = binarySearch(intervals, intervals[i][1]);
            res[i] = intervalIndex == -1 ? -1 : map.get(intervals[intervalIndex][0]);
        }

        return res;
    }

    private int binarySearch(int[][] intervals, int target) {
        int l = 0, r = intervals.length - 1;
        
        if(target > intervals[r][0]) {
            return -1;
        }
        
        while (l < r) {
            int m = l + (r - l) / 2;
            if (intervals[m][0] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
```