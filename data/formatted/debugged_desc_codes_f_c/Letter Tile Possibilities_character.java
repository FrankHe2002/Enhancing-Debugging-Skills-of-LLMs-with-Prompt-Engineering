The bug in the given code is a syntax error, a missing semicolon in the `if` statement. To fix the bug, the missing semicolon after the `if` condition will be added.

Fix:
```java
public void find(Map<Character, Integer> map) {
    result++;
    for (Map.Entry<Character, Integer> m : map.entrySet()) {
        char c = m.getKey();
        int val = m.getValue();
        if (val > 0) {  // Added the missing semicolon
            map.put(c, val - 1);
            find(map);
            map.put(c, val);
        }
    }
}
```