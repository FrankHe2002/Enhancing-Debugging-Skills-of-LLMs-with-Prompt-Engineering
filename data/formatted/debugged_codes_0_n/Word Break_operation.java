```java
// Runtime: 19 ms (Top 29.34%) | Memory: 47.2 MB (Top 33.05%)
class Solution {
    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 1; i < s.length() + 1; ++ i) {
            String left = s.substring(0, i);
            if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
```