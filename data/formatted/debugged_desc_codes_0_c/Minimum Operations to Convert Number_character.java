There are a few bugs in the code:

1. The for loop declaration is missing a semicolon after the i = 0 part.
2. The logic of adding the current value to the set of visited numbers is incorrect. It should be done only after all the operations for the current value have been performed.

Here's the revised and fixed code:

```java
import java.util.*;

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) { // Fixed: added semicolon
                int val = q.poll();
                if (val == goal) return res;
                if (val < 0 || val > 1000 || set.contains(val)) continue;

                for (int num : nums) {
                    q.offer(val + num);
                    q.offer(val - num);
                    q.offer(val ^ num);
                }
                set.add(val); // Fixed: moved here
            }
            res++;
        }

        return -1;
    }
}
```

The bugs have been fixed by adding the missing semicolon in the for loop declaration and moving the addition of the current value to the set of visited numbers to the correct position within the loop.