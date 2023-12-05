The bug in the provided solution is in the definition and usage of the Map. The type of key used in the Map is `int[]`, which is an array type, and in Java, arrays do not override the default implementation of the `hashCode` and `equals` methods.

Since array instances are compared by reference by default, this will not work as expected. When we store an array as a key in a Map, we might not be able to retrieve it using the same array.

To fix this bug, we need to find an alternate way to pair each interval with its original index, and we can use a HashMap to store the start index and interval pairs. Therefore, we will update the input type for the key to be a pair of integers. Also, instead of using `intervals[length]`, we should use `intervals[i]` to store the intervals and their original indices.

To address the bug, the following changes should be made:

1. Change the type of the key in the HashMap to `int[]` from `Map<int[], Integer>` to `Map<int[], Integer>`.
2. Use intervals[i] to store the intervals and their original indices in the HashMap.

The revised and fixed code in markdown is as follows -

```java
/*
- Time: O(N*log(N))
Loop through the array with n elements and run binary search with log(N) time for each of them.

- Space: O(N)
Used a hashmap map of size N to store the original indeces of intervals
 */
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
            int[] interval = binarySearch(intervals, intervals[i][1], i);
            res[map.get(intervals[i][0])] = interval == null ? -1 : map.get(interval[0]);
        }
        return res;
    }

    private int[] binarySearch(int[][] intervals, int target, int start) {
        int l = start, r = intervals.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (intervals[m][0] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l == intervals.length ? null : intervals[l];
    }
}
```