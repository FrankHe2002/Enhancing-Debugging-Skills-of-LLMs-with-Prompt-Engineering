Bug type: Syntax error

Bug explanation:
1. In the `inRange` method, there is a typo in the code. Instead of using `u[check]`, it should be `u[1]`.
2. The method `maximumDetonation` is missing the `static` keyword, which is required for execution.

Fix reasoning:
To fix the first error, we need to replace `u[check]` with `u[1]` in the `inRange` method.
To fix the second error, we need to add the `static` keyword before the `maximumDetonation` method.

Fixed code:
```java
// Runtime: 234 ms (Top 36.67%) | Memory: 42.3 MB (Top 94.92%)
class Solution {
    /*
    Make directed graph
    u -> v means, v is in the range of u
    check from which node maximum nodes can be reached and return the number of nodes reached
    */
    public static int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (inRange(bombs[i], bombs[j]))
                    graph.get(i).add(j);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, graph, new HashSet<>()));
        }
        return max;
    }

    private static boolean inRange(int[] u, int[] v) {
        // (x-a)^2 + (y-b)^2 = R^2 -> point (a, b) is at border
        // (x-a)^2 + (y-b)^2 < R^2 -> point (a, b) is inside the circle
        // (x-a)^2 + (y-b)^2 > R^2 -> point (a, b) is outside the circle
        return Math.pow(u[0] - v[0], 2) + Math.pow(u[1] - v[1], 2) <= Math.pow(u[2], 2);
    }

    private static int dfs(int node, Map<Integer,