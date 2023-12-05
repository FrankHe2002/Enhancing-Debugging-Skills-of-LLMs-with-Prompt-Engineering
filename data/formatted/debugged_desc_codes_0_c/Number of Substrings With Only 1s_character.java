The bug in the code is the incorrect placement of the curly braces and the "if-else" condition. The intended logic is to increment the count if the character is '1', and then add the count to the result. However, due to the misplaced curly braces, the "result += count;" line is executed outside of the if-else block for every iteration. This results in incorrect counting of substrings with all characters as 1's.

To fix this, the placement of curly braces and the "if-else" condition need to be adjusted. Additionally, the variable "count" should be reset to 0 when the character is '0'.

Here is the corrected code:

```java
class Solution {
    public int numSub(String s) {
        char[] ch = s.toCharArray();
        long count = 0;
        long result = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                count++;
                result += count;
            } else {
                count = 0;
            }
        }
        return (int) (result % 1000000007);
    }
}
```