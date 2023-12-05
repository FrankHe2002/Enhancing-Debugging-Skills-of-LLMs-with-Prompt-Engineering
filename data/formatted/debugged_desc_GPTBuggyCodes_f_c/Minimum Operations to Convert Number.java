The bug in the provided Java code is in the nested for loop where the bitwise-XOR operation is incorrectly used. Another bug is in the condition `val ^ num ^ num`, which can be simplified to `val ^ num`. A logical error in the condition within the `while` loop is also present, leading to incorrect results. 

To fix this, the condition checking for invalid `val` in the range `0 <= x <= 1000` should be moved inside the for loop. Additionally, the `xor` operation used inside the loop is incorrect. 

Here's the fixed code:

```java
import java.util.*;

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(start);
        while (! q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int val = q.poll();
                if (val == goal) return res;
                if (val < 0 || val > 1000 || set.contains(val)) continue;
                set.add(val);

                for (int num : nums) {
                    int plus = val + num;
                    int minus = val - num;
                    int xor = val ^ num;
                    q.offer(plus);
                    q.offer(minus);
                    q.offer(xor);
                }
            }
            res++;
        }
        return -1;
    }
}
```
I've included the changes mentioned above for your reference.