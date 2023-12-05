```java
class Solution {
    private int result = 0;

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        find(map);
        return result;
    }

    public void find(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            char c = m.getKey();
            int val = m.getValue();
            if (val > 0) {
                result++;
                map.put(c, val - 1);
                find(map);
                map.put(c, val);
            }
        }
    }
}
```