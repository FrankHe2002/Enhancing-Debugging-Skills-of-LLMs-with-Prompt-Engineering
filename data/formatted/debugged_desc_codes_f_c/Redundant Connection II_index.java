The bug in the provided Java code is related to incorrect array index management and incorrect semicolon placement.

The first issue is with index handling:
In the for-loop of the findRedundantDirectedConnection method, when assigning the parent, the code uses parent[to + 1] to check if a parent already exists for the child. This should be parent[to] instead. 
The code is supposed to work within the boundaries of the parent array correctly.

The second issue is related to the missing semicolon:
In the findRedundantDirectedConnection method, when assigning the parent (parent[to] = from;), there is no semicolon at the end of the statement, causing a syntax error in the code.

The fix includes:
- Changing parent[to + 1] to parent[to].
- Adding a semicolon at the end of the statement parent[to] = from.

Here's the fixed code:
```java
import java.util.*;

class Solution {
    int[] dsu;

    public int find(int x) {
        if (dsu[x] == x) return x;
        return dsu[x] = find(dsu[x]);
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        int[] e2 = null;
        int[] e1 = null;
        boolean twopt = false;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (parent[to] == -1) {
                parent[to] = from;
            } else {
                twopt = true;
                e2 = edge;
                e1 = new int[]{parent[to], to};
                break;
            }
        }

        dsu = new int[edges.length + 1];
        for (int i = 0; i <= edges.length; i++) {
            dsu[i] = i;
        }
        if (!twopt) {
            int[] res = null;

            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];

                int fromlead = find(from);
                if (fromlead == to) {
                    res = edge;
                    break;
                } else {
                    dsu[to] = fromlead;
                }
            }
            return res;
        } else {
            boolean iscycle = false;
            for (int[] edge : edges) {
                if (edge == e2) continue;
                int from = edge[0];
                int to = edge[1];

                int fromlead = find(from);

                if (fromlead == to) {
                    iscycle = true;
                    break;
                } else {
                    dsu[to] = fromlead;
                }
            }
            if (iscycle) {
                return e1;
            } else {
                return e2;
            }
        }
    }
}
```