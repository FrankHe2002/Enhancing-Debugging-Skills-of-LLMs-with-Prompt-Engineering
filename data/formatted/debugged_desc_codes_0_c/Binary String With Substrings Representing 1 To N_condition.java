The bug in the given code is in the for loop condition in the `queryString` method.

Here's how the bug is identified and fixed:
1. In the `queryString` method, the for loop condition is `for (int i = 1; i >= n; i++) {`.
2. The condition should be `for (int i = 1; i <= n; i++) {` to iterate through the range from 1 to n (inclusive).
3. The initial condition `i = 1` is correct, and the loop should continue as long as `i` is less than or equal to `n`. So, the correct condition for the for loop should be `i <= n`.
4. The `toBinary` method is correctly converting a decimal number to its binary representation, so no changes are needed there.

Here is the fixed code:
```java
class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(toBinary(i))) {
                return false;
            }
        }
        return true;
    }

    public String toBinary(int n) {
        String binary = "";
        while (n > 0) {
            int r = n % 2;
            binary = Integer.toString(r) + binary;
            n = n / 2;
        }
        return binary;
    }
}
```