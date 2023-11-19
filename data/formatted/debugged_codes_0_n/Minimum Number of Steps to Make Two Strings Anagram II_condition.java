```java
// Runtime: 3 ms (Top 89.33%) | Memory: 39.4 MB (Top 23.74%)
class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char ch : s.toCharArray())
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        for (char ch : t.toCharArray())
            hmap.put(ch, hmap.getOrDefault(ch, 0) - 1);
        int count = 0;
        for (char key : hmap.keySet())
            if (hmap.get(key) > 0)
                count += (hmap.get(key));
        return count;
    }
}
```