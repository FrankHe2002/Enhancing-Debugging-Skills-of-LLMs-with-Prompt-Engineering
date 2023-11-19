The bug in the provided code is a syntax error in the `find` method. The line `if val > 0)` is missing parentheses and should be `if (val > 0)`.

To fix this bug, we can simply add the missing parentheses in the `if` statement.

Here is the corrected code:

```java
import java.util.*;

class Solution {
    private int result = 0;

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        find(map);
        return result - 1;
    }

    public void find(Map<Character, Integer> map) {
        result++;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            char c = m.getKey();
            int val = m.getValue();
            if (val > 0) {
                map.put(c, val - 1);
                find(map);
                map.put(c, val);
            }
        }
    }
}
```