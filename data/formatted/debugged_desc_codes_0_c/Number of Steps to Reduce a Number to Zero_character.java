Bug type: Syntax error

Reasoning:
The code has a syntax error in the `numberOfSteps` method where the closing parenthesis for the `return` statement is missing.

Thinking process:
1. The error seems to be a simple syntax error in the `numberOfSteps` method.
2. The error should be located close to where the code terminates.
3. A missing parenthesis would cause a syntax error.

Fix:
Add the closing parenthesis to the `return` statement in the `numberOfSteps` method.

The corrected code:
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