Fix:
```java
import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].contains(s) && !ans.contains(s)) {
                    ans.add(s);
                    break;
                }
            }
        }
        return ans;
    }
}
```