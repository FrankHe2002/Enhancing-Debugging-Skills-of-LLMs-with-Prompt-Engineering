The bug in the provided code is that it increments `i` by 3 when `s.charAt(i)` is equal to 'X'. However, the prompt doesn't specify that consecutive 'X's need to be removed in a single step. Therefore, the condition should be changed to increment `i` by 1 in order to count each 'X' as a separate step.

The fixed code is shown below:

```java
// Runtime: 1 ms (Top 83.6%) | Memory: 41.00 MB (Top 8.7%)
class Solution {
    public int minimumMoves(String s) {
        int i = 0;
        int step = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                i++;
                step++;
            } else {
                i++;
            }
        }
        return step;
    }
}
```