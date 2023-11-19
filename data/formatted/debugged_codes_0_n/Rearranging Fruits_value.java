```java
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> ac = new HashMap<>();
        Map<Integer, Integer> cm = new HashMap<>();
        for (int i = 0; i < basket1.length; i++) {
            ac.merge(basket1[i], 1, Integer::sum);
            cm.merge(basket1[i], 1, Integer::sum);
            cm.merge(basket2[i], 1, Integer::sum);
        }

        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> m = new TreeMap<>();
        for (Map.Entry<Integer, Integer> e : cm.entrySet()) {
            if (e.getValue() % 2 == 1) {
                return -1;
            }
            min = Math.min(min, e.getKey());
            int missingCount = ac.getOrDefault(e.getKey(), 0) - e.getValue() / 2;
            if (missingCount == 0) {
                continue;
            }
            m.merge(e.getKey(), Math.abs(missingCount), Integer::sum);
        }

        long res = 0;
        while (!m.isEmpty()) {
            if (m.firstKey() <= min * 2) {
                res += m.firstKey();
                if (m.merge(m.firstKey(), -1, Integer::sum) == 0) {
                    m.remove(m.firstKey());
                }
                if (m.merge(m.lastKey(), -1, Integer::sum) == 0) {
                    m.remove(m.lastKey());
                }
            } else {
                res += min * 2;
                if (m.merge(m.lastKey(), -1, Integer::sum) == 0) {
                    m.remove(m.lastKey());
                }
                if (m.merge(m.lastKey(), -1, Integer::sum) == 0) {
                    m.remove(m.lastKey());
                }
            }
        }
        return res;
    }
}
```