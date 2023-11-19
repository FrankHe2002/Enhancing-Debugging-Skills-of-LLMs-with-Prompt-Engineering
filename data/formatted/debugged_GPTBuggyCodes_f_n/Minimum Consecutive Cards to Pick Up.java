```java
// Runtime: 51 ms (Top 92.02%) | Memory: 61 MB (Top 90.10%)

class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) { 
            if (map.containsKey(cards[i]))
                min = Math.min(i - map.get(cards[i]) + 1, min); 
            map.put(cards[i], i); 
        }
        return min == Integer.MAX_VALUE ? - 1 : min; 
    }
}
```