The provided Java code has various issues leading to buggy behavior. Let's review and fix the issues.

Issues:
1. In the method `numSub`, the if block and else block are missing curly braces, and both statements `result += count;` and `count = 0;` will unconditionally execute due to the missing curly braces.
2. In the same `numSub` method, the result calculation is incorrect. The result should reflect the count of contiguous substrings with all characters as '1's. The positions of 1's in the binary string should contribute to form a contiguous substring. The current implementation of the result calculation is inadequate.
3. There's a missing opening curly brace of the `if` block to check if `ch[i] == '1'`, leading to incorrect conditional execution of statements.

Fixes:
1. Add the required opening and closing curly braces for the if and else block.
2. Revise the logic within the for loop to correctly count contiguous substrings with all characters as '1's.
3. Change the string loop to be more descriptive

```java
class Solution {
    public int numSub(String s) {
        char[] ch = s.toCharArray();
        long count = 0;
        long result = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                count++;
                result = (result + count) % 1000000007;
            } else {
                count = 0;
            }
        }
        return (int) result;
    }
}
```