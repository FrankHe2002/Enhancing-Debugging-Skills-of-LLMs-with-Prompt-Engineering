The bug type in the code is a syntax error. The for loop is missing a closing parenthesis ")" at the end of the for loop declaration.

To fix this bug, we need to add the closing parenthesis ")" at the end of the for loop declaration.

Here's the corrected code:

```java
class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        int p1 = 1;
        int p2 = 1;
        int p3 = 0;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = p1 + p2 + p3;
            p3 = p2;
            p2 = p1;
            p1 = cur;
        }
        return cur;
    }
}
```