The bug in the given Java code is that it adds the same substring multiple times to the result list `ans`.

To fix this bug, we can check if the substring `s` is already present in the result list before adding it. If it is present, we can break out of the inner loop and move to the next substring.

Here's the fixed code:

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
                if (words[j].indexOf(s) >= 0 && !ans.contains(s)) {
                    ans.add(s);
                    break;
                }
            }
        }
        return ans;
    }
}
```