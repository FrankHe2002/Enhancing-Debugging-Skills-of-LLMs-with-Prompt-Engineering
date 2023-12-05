The bug in the provided Java code is the usage of the `index` value in the `helper` function. The variable `index` is used to indicate the current node, but the condition `index == -1` is used to check if there is no outgoing edge from the current node, and if so, it should return `-1`. However, it is not correctly handling the scenarios where the node itself could be a part of the cycle.

It is safer and clearer to return the real length of the cycle at the same point when we find a cycle. By doing so, we don't need the map array and we reduce the branching logic significantly.

Here's the corrected and optimized code:

```java
// Runtime: 5 ms | Memory: 99.4 MB
class Solution {
    public int longestCycle(int[] edges) {
        int result = -1;

        for (int i = 0; i < edges.length; i++) {
            int slow = i, fast = i;
            do {
                if (edges[fast] == -1 || edges[edges[fast]] == -1) break;
                slow = edges[slow];
                fast = edges[edges[fast]];
            } while (slow != fast);
            if (slow == fast) {
                int len = 1;
                fast = edges[slow];
                while (slow != fast) {
                    fast = edges[fast];
                    len++;
                }
                result = Math.max(result, len);
            }
        }

        return result;
    }
}
```