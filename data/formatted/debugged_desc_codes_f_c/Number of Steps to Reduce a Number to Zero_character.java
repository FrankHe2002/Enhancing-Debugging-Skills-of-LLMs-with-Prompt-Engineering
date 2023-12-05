Explanation:
The error here is a missing closing parenthesis (`)`) at the end of `return helper(num, 0;`. The error in syntax leads to a compilation error.

Fix:
```java
class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    public int helper(int n, int c) {
        if (n == 0) return c;
        if (n % 2 == 0) {
            return helper(n / 2, c + 1);     //check for even no.
        }

        return helper(n - 1, c + 1);
    }
}
```