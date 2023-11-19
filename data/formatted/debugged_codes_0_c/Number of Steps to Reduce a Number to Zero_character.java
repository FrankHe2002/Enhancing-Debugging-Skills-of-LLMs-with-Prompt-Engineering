The bug in the provided Java code is a syntax error in the return statement of the `numberOfSteps` method. The closing parenthesis for the `helper` method call is missing.

To fix this bug, the missing closing parenthesis should be added to the return statement of the `numberOfSteps` method. The corrected code will look like this:

```java
class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    public int helper(int n, int c) {
        if (n == 0) return c;
        if (n % 2 == 0) {
            return helper(n / 2, c + 1);
        }

        return helper(n - 1, c + 1);
    }
}
```