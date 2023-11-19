```java
class Solution {
    public int partitionString(String s) {
        int idx = 0;
        int count = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while (idx < s.length()) {
            if (mp.containsKey(s.charAt(idx))) {
                count++;
                idx = mp.get(s.charAt(idx)) + 1;
                mp.clear();
            } else {
                mp.put(s.charAt(idx), idx);
                idx++;
            }
        }
        return count + 1;
    }
}
```