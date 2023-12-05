The buggy Java code provided has multiple issues:

1. It should return the percentage rounded down, but it calculates percentage incorrectly using modulo operation.
2. The return type should be an integer but it returns per, which is a mismatch for the type.

The fix will involve calculating the percentage correctly using integer division and returning the final result as an integer. Here's the fixed code:
```java
class Solution {
    public int percentageLetter(String str, char letter) {
        int count = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == letter) {
                count++;
            }
        }
        int per = (100 * count) / n; // Correctly calculate the percentage
        return per; // Return the percentage
    }
}
```