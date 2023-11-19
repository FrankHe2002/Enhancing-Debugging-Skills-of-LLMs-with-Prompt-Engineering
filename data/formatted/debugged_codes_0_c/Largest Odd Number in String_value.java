The provided Java code seems to have a logical error. The purpose of the code is to find the largest odd number from a given string of digits. The code uses a for loop to iterate through the string from right to left. If it encounters an odd digit, it returns a substring from the beginning of the string to the current position.

However, the bug in the code is that it is checking the oddness of the character instead of the numeric value. The code uses the modulus operator `%` on the character, which will give the remainder when divided by 2. Since characters are represented by their ASCII values, this operation will not correctly determine the oddness of the digit itself.

To fix this bug, we need to convert the character to its numeric value before checking its oddness. This can be done by subtracting the character '0' from the digit character. This will give the numeric value of the digit.

Below is the corrected code:

```java
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i > -1; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
```

In the fixed code, we subtract the character '0' from the digit character `num.charAt(i)`. This gives us the numeric value of that digit. We then check if the digit is odd by using the modulus operator `%` to check if it is divisible by 2. If it is odd, we return the substring up to the current position. If no odd digits are found, we return an empty string.