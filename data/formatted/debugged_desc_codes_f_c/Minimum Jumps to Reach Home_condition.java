The identified bug is observed in the for loop of the `minimumJumps` function. The loop condition `i > forbidden.length` is incorrect, causing the loop not to iterate at all. The condition should be `i < forbidden.length` to ensure the loop iterates over each element of the 'forbidden' array.

Also, the condition for jumping left should be replacing '- 1' with '-1' to properly check if the previous move was a backward jump.

The fixed Java code is as follows:

```java
import java.util.*;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        // Visited Set
        Set<Integer> visited = new HashSet<Integer>();

        // Add forbidden coordinates to visited
        for (int i = 0; i < forbidden.length; i++) {
            visited.add(forbidden[i]);
        }

        // Distance/ Jumps map
        Map<Integer, Integer> jumps = new HashMap<>();
        jumps.put(0, 0);

        // BFS Queue
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {0, 1});

        // BFS 
        while (q.size() != 0) {
            Integer[] ud = q.poll();
            int u = ud[0], d = ud[1];

            // x found
            if (u == x) {
                return jumps.get(u);
            }

            // jump right
            if (u + a < 6001 && !visited.contains(u + a)) {
                q.add(new Integer[] {u + a, 1});
                visited.add(u + a);
                jumps.put(u + a, jumps.get(u) + 1);
            }

            // jump left
            if (d != -1 && u - b > -1 && !visited.contains(u - b)) {
                q.add(new Integer[] {u - b, -1});
                visited.add(u - b);
                jumps.put(u - b, jumps.get(u) + 1);
            }
        }

        return -1;
    }
}
```