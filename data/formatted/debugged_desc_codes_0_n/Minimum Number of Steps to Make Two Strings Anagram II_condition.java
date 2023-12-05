```java
// Runtime: 246 ms (Top 18.10%) | Memory: 118.1 MB (Top 5.07%)
class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char ch : s.toCharArray())
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        for (char ch : t.toCharArray())
            hmap.put(ch, hmap.getOrDefault(ch, 0) - 1);
        int count = 0;
        for (int value : hmap.values())
            count += (Math.abs(value));
        return count / 2;
    }
}
```