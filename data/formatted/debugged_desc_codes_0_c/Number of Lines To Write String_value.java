The bug in the code is that the variables `arr` and `count` are declared incorrectly. There is no need for `arr` to have a size of 4, and `count` should start from 1 instead of 0. Additionally, the sum should not be reset to 0 when it exceeds 100, instead, it should be set to the width of the current character.

Here's the corrected code:

```java
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, sum = 0;
        for (int j = 0; j < s.length(); j++) {
            int pos = s.charAt(j) - 'a';
            int width = widths[pos];
            if (sum + width > 100) {
                lines++;
                sum = 0;
            }
            sum += width;
        }
        return new int[]{lines, sum};
    }
}
```