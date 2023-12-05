The bug in the given code is a logical error in the for loop condition `for (int j = 0; i < g.length && j < s.length; j++)`. The loop should continue until both `i` and `j` are less than the length of their respective arrays, not until `i` is less than the length of the `g` array and `j` is less than the length of the `s` array.

Here's the corrected code:

```java
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
```

I corrected the condition in the for loop to `while (i < g.length && j < s.length)` and also moved the increment of `j` to the end of the loop and added the increment of `i` inside the if block if `g[i] <= s[j]`.