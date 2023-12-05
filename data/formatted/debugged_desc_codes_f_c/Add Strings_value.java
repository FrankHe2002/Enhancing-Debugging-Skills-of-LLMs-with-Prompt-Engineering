The bug in the provided code is that the code is using the `BigInteger` class, which is not allowed according to the constraints. Additionally, there is a typo error in the parameter names.

Fix:
```java
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        
        return sb.toString();
    }
}
```