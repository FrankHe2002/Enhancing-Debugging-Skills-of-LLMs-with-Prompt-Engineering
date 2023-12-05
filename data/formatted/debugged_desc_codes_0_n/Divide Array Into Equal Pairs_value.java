```java
// Runtime: 8 ms (Top 41.3%) | Memory: 44.12 MB (Top 12.5%)

import java.util.HashMap;

class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : map.keySet()) {
            if (map.get(i) % 2 != 0) return false;
        }
        return true;
    }
}
```