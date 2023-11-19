The bug in the provided code is that it doesn't correctly count the number of balanced strings. It only counts the number of times the number of "L" characters matches the number of "R" characters, instead of counting the number of balanced strings.

To fix the bug, we need to update the logic in the code to check for balanced strings instead of just counting the number of times the number of "L" characters equals the number of "R" characters.

Fixed Code:
```java
class Solution {
    public int balancedStringSplit(String s) {
        int nl = 0;
        int nr = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.substring(i, i + 1).equals("L")) {
                ++nl;
            } else {
                ++nr;
            }
            if (nl == nr) { // Check if the number of "L" and "R" characters are equal
                ++count; // Increment the count for a balanced string
                nl = 0; // Reset the counts for the next balanced string
                nr = 0;
            }
        }
        return count;
    }
}
```

Explanation:
In the original code, for each character in the string, it increments the count when the number of "R" characters equals the number of "L" characters. However, this logic does not correctly identify balanced strings since the count should only be incremented when both "R" and "L" characters occur an equal number of times. The fixed code compares the counts of "R" and "L" characters and increments the count only when they are equal. Additionally, we reset the counts `nl` and `nr` to zero after incrementing the count for a balanced string, so we can continue counting for the next string.