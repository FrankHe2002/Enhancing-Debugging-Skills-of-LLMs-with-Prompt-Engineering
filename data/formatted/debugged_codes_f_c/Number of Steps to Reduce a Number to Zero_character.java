Bug Type: Syntax Error

Reasoning: The provided buggy code has a missing closing parenthesis ")" in the line `return helper(num, 0;`. It should be `return helper(num, 0);` to correctly close the parentheses. 

Fix:

```java
class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    public int helper(int n, int c) {
        if (n == 0) return c;
        if (n % 2 == 0) {              //check for even no.
            return helper(n / 2, c + 1);
        }

        return helper(n - 1, c + 1);
    }
}
```