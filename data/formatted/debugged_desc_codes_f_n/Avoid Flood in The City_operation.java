```java
// Runtime: 70 ms (Top 47.1%) | Memory: 59.86 MB (Top 71.2%)

class Solution {
    public int[] avoidFlood(int[] rains) {
        // the previous appeared idx of rains[i]
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                zeros.add(i);
                res[i] = 1; // If there are no rains this day and we need to dry a lake, set res[i] = 1
            } else {
                if (map.containsKey(rains[i])) {
                    // find the location of zero that can be used to empty rains[i]
                    Integer next = zeros.ceiling(map.get(rains[i]));
                    if (next == null) return new int[0]; // Return an empty array if it is impossible to avoid flood
                    res[next] = rains[i];
                    zeros.remove(next);
                }
                res[i] = -1; // If there are rains, set res[i] = -1
                map.put(rains[i], i);
            }
        }
        return res;
    }
}
```