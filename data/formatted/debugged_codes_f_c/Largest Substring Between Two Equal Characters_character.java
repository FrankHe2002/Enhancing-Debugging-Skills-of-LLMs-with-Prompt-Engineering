Buggy Code Fix:
```java
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = - 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                ans = Math.max(ans, i - 1 - map.get(ch));
            } else {
                map.put(ch, i);
            }
        }
        return ans;
    }
}

```
The bug in the provided code is a missing semicolon at the end of the statement `char ch = s.charAt(i)`. Adding a semicolon at the end of the statement corrects this syntax error.