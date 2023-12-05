The bug in the provided Java code is that the code is using the `BigInteger` class, which is explicitly mentioned in the code description as something that should not be used.

To fix the bug, we should modify the code to implement the addition of two string numbers without using the `BigInteger` class.

Here's the fixed code:

```java
// Runtime: 2 ms | Memory: 39.5 MB

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
        }

        return result.toString();
    }
}
```

In the fixed code:
- We iterate through both input strings in reverse and add the digits along with the carry.
- We use a `StringBuilder` to efficiently build the result.
- We return the result as a string.