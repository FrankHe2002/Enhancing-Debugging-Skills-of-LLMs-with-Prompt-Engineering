Bug Type: Syntax Error

Reasoning: The code has a syntax error on the last line of the code. It adds a `+` before the `1` which is not necessary.

Fix:

```java
import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (! hmap.containsKey(s.charAt(i))) {
                hmap.put(s.charAt(i), 1);
            } else {
                hmap.put(s.charAt(i), hmap.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hmap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
```
Additionally, the `import java.util.HashMap;` statement should be added at the beginning of the code since the `HashMap` class is used.