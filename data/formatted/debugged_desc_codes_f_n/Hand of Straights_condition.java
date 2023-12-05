```java
// Runtime: 96 ms (Top 31.30%) | Memory: 61.2 MB (Top 7.04%)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for (int start : map.keySet()) {
            int occurrences = map.get(start);
            if (occurrences > 0) {
                for (int i = start; i < start + groupSize; i++) {
                    if (map.getOrDefault(i, 0) < occurrences)
                        return false;
                    map.put(i, map.get(i) - occurrences);
                }
            }
        }

        return true;
    }
}
```