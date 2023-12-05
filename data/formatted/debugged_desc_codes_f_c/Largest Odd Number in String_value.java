The bug in the provided Java code is that it's checking for the oddness of a character instead of the digit represented by that character.

Explanation:
The `largestOddNumber` method has an incorrect implementation of checking for odd digits. The code should convert the character to its integer value and then check if it's odd. Also, because the integer represented by the string should not have leading zeros, the bug should be fixed so that the loop and return values account for that constraint.

Fix:
```java
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i > -1; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) return num.substring(0, i + 1);
        }
        return "";
    }
}
```