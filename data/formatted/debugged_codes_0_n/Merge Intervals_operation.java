```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                list.add(intervals[i]);
            } else {
                int[] prev = list.get(list.size() - 1);
                int[] curr = intervals[i];
                if (curr[0] <= prev[1]) {
                    prev[1] = Math.max(curr[1], prev[1]);
                } else {
                    list.add(curr);
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
```