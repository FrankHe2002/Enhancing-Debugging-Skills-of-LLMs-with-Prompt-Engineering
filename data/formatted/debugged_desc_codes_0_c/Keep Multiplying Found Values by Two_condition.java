The bug in the given code is that the while loop does not have curly braces to properly enclose the if-else conditions. This causes only the first statement after the while loop to be considered as part of the loop, and the else block becomes unrelated to the loop, hence leading to an incorrectly functioning program.

To fix this issue, I will add curl braces around the if-else block inside the while loop to ensure that both the if and else statements are part of the loop.

Here's the corrected code:

```java
import java.util.*;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            if (i < original)
                set.add(i);
        while (true) {
            if (set.contains(original))
                original *= 2;
            else
                break;
        }
        return original;
    }
}
```