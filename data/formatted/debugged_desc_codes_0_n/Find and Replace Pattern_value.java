```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            Map<Character, Character> reverseMap = new HashMap<>();
            boolean isValid = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = pattern.charAt(i);
                if (map.containsKey(ch)) {
                    if (map.get(ch) != word.charAt(i)) {
                        isValid = false;
                        break;
                    }
                } else {
                    if (reverseMap.containsKey(word.charAt(i))) {
                        isValid = false;
                        break;
                    }
                    map.put(ch, word.charAt(i));
                    reverseMap.put(word.charAt(i), ch);
                }
            }
            if (isValid) {
                result.add(word);
            }
        }
        return result;
    }
}
```