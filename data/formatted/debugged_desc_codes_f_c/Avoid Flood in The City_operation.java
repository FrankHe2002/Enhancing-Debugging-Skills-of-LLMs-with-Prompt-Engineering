The bug in this code is in the line `res[i] = % 1;`. The code is attempting to store the value `rains[i]` in the `res` array, but the syntax `% 1` is incorrect.

The fix is to correct the syntax by replacing `res[i] = % 1;` with `res[i] = 1;`.

Fixed code:
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
            } else {
                if (map.containsKey(rains[i])) {
                    // find the location of zero that can be used to empty rains[i]
                    Integer next = zeros.ceiling(map.get(rains[i]));
                    if (next == null) return new int[0];
                    res[next] = rains[i];
                    zeros.remove(next);
                }
                res[i] = 1;
                map.put(rains[i], i);
            }
        }
        for (int i : zeros) res[i] = 1;
        return res;
    }
}
```