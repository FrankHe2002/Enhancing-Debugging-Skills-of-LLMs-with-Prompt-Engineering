```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;

        List<int[]> merged = new LinkedList<>();
        int i = -1;
        // add not overlapping
        while (i < intervals.length - 1 && intervals[i + 1][1] < newInterval[0]) {
            merged.add(intervals[i + 1]);
            i++;
        }
        // add overlapping
        while (i < intervals.length - 1 && intervals[i + 1][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i + 1][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i + 1][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);
        // add rest
        while (i < intervals.length - 1) {
            merged.add(intervals[i + 1]);
            i++;
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
```