Bug Type: Syntax error

Bug Explanation: The code is missing the parentheses for the for loop in the inner loop. It should be "for (int j = 0; j < strs.length - 1; j++)" instead of "for int j = 0; j < strs.length - 1; j++)". 

Fix: Add parentheses for the for loop in the inner loop.

```java
class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) { //strs[0].length() is used to find the length of the column
            for (int j = 0; j < strs.length - 1; j++) {
                if ((int) strs[j].charAt(i) <= (int) strs[j + 1].charAt(i)) {
                    continue;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
```