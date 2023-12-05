The bug type is a logical error. The original code incorrectly checks if the numbers in the string are strictly increasing from left to right. Additionally, the try-catch block is unnecessary and inefficient.

To fix the logical error, we need to compare each number parsed from the string with the previous number and return false if it's not strictly greater. We can remove the try-catch block and use an else statement to handle non-numeric tokens.

The fixed code is as follows:

```java
class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = -1; // Set initial previous value to -1 to handle cases where the first number is 0

        for (String token : s.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                int number = Integer.parseInt(token);
                if (number <= prev) {
                    return false;
                }
                prev = number;
            }
        }

        return true;
    }
}
```