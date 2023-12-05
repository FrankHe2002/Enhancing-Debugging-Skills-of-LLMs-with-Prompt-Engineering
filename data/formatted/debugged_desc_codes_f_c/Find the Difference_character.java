The given code is for finding the difference between two strings `s` and `t` by finding the extra letter present in `t` which is not present in `s`. But the code provided has a syntax error.

Fix:
```java
class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray()) c ^= cs;
        for (char ct : t.toCharArray()) c ^= ct;
        return c;
    }
}
```