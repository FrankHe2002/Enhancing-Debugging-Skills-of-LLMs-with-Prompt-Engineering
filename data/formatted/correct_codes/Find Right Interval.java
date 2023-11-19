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
            res[map.get(intervals[i])] = interval == null ? - 1 : map.get(interval);
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
