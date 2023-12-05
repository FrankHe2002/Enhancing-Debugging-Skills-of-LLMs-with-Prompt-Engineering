Fix:
```java
import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int card : hand) {
            if (map.containsKey(card))
                map.put(card, map.get(card) + 1);
            else
                map.put(card, 1);
        }

        for (int key : map.keySet()) {
            int curr = map.get(key);
            if (curr == 0)
                continue;
            for (int j = groupSize - 1; j >= 0; j--) {
                if (map.containsKey(key + j)) {
                    map.put(key + j, map.get(key + j) - curr);
                    if (map.get(key + j) < 0)
                        return false;
                } else
                    return false;
            }
        }
        return true;
    }
}
```