The given Java code appears to have a bug. The bug type is logical error.

To identify and fix the bug, we need to understand the problem and review the code step by step:

1. The problem states that we need to find the minimum number of moves required to convert all characters of the string to 'O'.
2. The given code iterates through the string and increments the step count whenever it encounters a character 'X'.
3. However, the code only considers consecutive occurrences of 'X' to count the number of moves, which is not correct. It does not cover cases where 'X' characters are not consecutive.

To fix the bug:
1. We need to modify the logic to count every occurrence of 'X' as a move.
2. We can achieve this by iterating through the string and checking each character. If the current character is 'X', we increment the step count.

Here's the modified code with the bug fix:
```java
class Solution {
    public int minimumMoves(String s) {
        int step = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                step++;
                i += 2; // Skip the next two characters
            }
        }
        return step;
    }
}
```
This fix ensures that we consider every occurrence of 'X' as a move, which aligns with the problem requirements.