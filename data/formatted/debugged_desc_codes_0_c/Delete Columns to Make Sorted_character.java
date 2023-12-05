The bug in the provided Java code is a syntax error. In the inner for loop, the 'int' keyword is missing, and there is a logical mistake in the comparison of characters. The loop should start from 0 and end at strs.length instead of strs.length - 1.

Here's the fixed code:

```java
class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
```