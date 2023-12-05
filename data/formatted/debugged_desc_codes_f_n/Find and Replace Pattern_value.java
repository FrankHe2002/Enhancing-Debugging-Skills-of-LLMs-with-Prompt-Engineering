Fix:
```java
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            boolean match = true;
            for (int i = 0; i < pattern.length(); i++) {
                char ch = pattern.charAt(i);
                char w = word.charAt(i);
                if (map.containsKey(ch)) {
                    if (map.get(ch) != w) {
                        match = false;
                        break;
                    }
                } else {
                    if (set.contains(w)) {
                        match = false;
                        break;
                    }
                    map.put(ch, w);
                    set.add(w);
                }
            }
            if (match) result.add(word);
        }
        return result;
    }
}
```