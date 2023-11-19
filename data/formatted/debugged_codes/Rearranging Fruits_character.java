import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        var ac = new HashMap<Integer, Integer>();
        var cm = new HashMap<Integer, Integer>();
        for (int i = 0; i < basket1.length; i++) {
            ac.merge(basket1[i], 1, Integer::sum);
            cm.merge(basket1[i], 1, Integer::sum);
            cm.merge(basket2[i], 1, Integer::sum);
        }

        int min = Integer.MAX_VALUE;
        var m = new TreeMap<Integer, Integer>();
        for (var e : cm.entrySet()) {
            if (e.getValue() % 2 == 1) {
                return - 1;
            }
            min = Math.min(min, e.getKey());
            var missingCount = ac.getOrDefault(e.getKey(), 0) - e.getValue() / 2;
            if (missingCount == 0) {
                continue;
            }
            m.merge(e.getKey(), Math.abs(missingCount), Integer::sum);
        }

        long res = 0;
        while (m.size() > 0) {
            if (m.firstKey() <= min * 2) {
                res += m.firstKey();
                if (m.merge(m.firstKey(), - 1, Integer::sum) == 0) {
                    m.remove(m.firstKey());
                }
                if (m.merge(m.lastKey(), - 1, Integer::sum) == 0) {
                    m.remove(m.lastKey());
                }
            } else {
                res += min * 2;
                if (m.merge(m.lastKey(), - 1, Integer::sum) == 0) {
                    m.remove(m.lastKey());
                }
                if (m.merge(m.lastKey(), - 1, Integer::sum) == 0) {
                    m.remove(m.lastKey());
                }
            }
        }
        return res;
    }
}