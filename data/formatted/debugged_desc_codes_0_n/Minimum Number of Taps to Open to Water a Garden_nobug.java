```java
// Runtime: 1 ms (Top 99%) | Memory: 39 MB (Top 34.87%)
class Solution {
    public int minTaps(int n, int[] ranges) {
        Integer[] idx = IntStream.range(0, ranges.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(o -> o - ranges[o]));
        int ans = 0, cur = 0, end = 0;
        for (int i = 0; i < ranges.length && end < n; i++) {
            int j = idx[i];
            if (j - ranges[j] > cur) {
                cur = end;
                ans++;
            }
            if (j - ranges[j] <= cur) {
                end = Math.max(end, j + ranges[j]);
            }
        }
        return end < n ? -1 : ans;
    }
}
```