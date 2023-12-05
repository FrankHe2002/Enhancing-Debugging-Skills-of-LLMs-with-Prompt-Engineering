Fix:
```java
import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        String prev = "";
        List<String> li = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            String curr = String.valueOf(ch);
            if (!li.contains(words[i])) {
                li.add(words[i]);
                prev = curr;
            }
        }
        return li;
    }
}
```