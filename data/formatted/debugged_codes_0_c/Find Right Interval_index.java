The bug in the provided code is in the following line:
```java
map.put(intervals[length], i);
```
The variable "length" is not declared or defined anywhere in the code. It should be replaced with "i" to store the index of the interval in the hashmap.

Here's the corrected code:

```java
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i], i);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int[] interval = binarySearch(intervals, intervals[i][1], i);
            res[map.get(intervals[i])] = interval == null ? -1 : map.get(interval);
        }

        return res;
    }

    private int[] binarySearch(int[][] intervals, int target, int start) {
        int l = start, r = intervals.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (intervals[m][0] >= target) {
                // keep moving the right boundary to the left to get the first
                // element bigger than target
                r = m - 1;
            } else {
                // if the element we get is bigger than the target, we move the 
                // left boundary to look at right part of the array
                l = m + 1;
            }
        }
        return l == intervals.length ? null : intervals[l];
    }
}
```

The bug has been fixed by replacing `intervals[length]` with `intervals[i]` in line 10.