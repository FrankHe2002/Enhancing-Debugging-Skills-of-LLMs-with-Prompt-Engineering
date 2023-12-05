```java
// Runtime: 76 ms (Top 31.30%) | Memory: 61.2 MB (Top 7.04%)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for (int card : map.keySet()) {
            minHeap.add(card);
        }

        while (!minHeap.isEmpty()) {
            int min = minHeap.poll();
            for (int i = min + 1; i < min + groupSize; i++) {
                if (!map.containsKey(i) || map.get(i) < map.get(min)) {
                    return false;
                }
                map.put(i, map.get(i) - map.get(min));
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;
    }
}
```