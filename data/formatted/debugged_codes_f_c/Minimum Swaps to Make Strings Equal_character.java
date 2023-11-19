The bug in the provided code is a syntax error. The line `int n = s1.length)` is missing a closing parenthesis (`)`), causing a compilation error.

To fix the bug, we need to add the missing closing parenthesis after `s1.length`. The correct line should be `int n = s1.length();`.

Fixed Code:
```java
class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return - 1;
        int n = s1.length();
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 == 'x' && c2 == 'y') x++;
            else if (c1 == 'y' && c2 == 'x') y++;
        }

        if (x % 2 == 0 && y % 2 == 0) return x / 2 + y / 2;
        else if (x % 2 == 1 && y % 2 == 1) return x / 2 + y / 2 + 2;
        return - 1;
    }
}
```