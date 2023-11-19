Bug type: Syntax error

Reasoning: Checking the code, there is a syntax error at the line `res[i] = % 1;`. The `%` symbol is not properly used and it is creating a syntax error. 

Fix: Remove the `%` symbol from the line.

Updated code:

```java
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