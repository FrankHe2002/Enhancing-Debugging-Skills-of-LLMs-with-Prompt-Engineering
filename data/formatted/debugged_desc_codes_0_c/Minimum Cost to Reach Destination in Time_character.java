There is a syntax error in the provided Java code. The "record" keyword is used, which indicates the use of records introduced in Java 16. However, the current Java version might not support records. We can replace the "record" keyword with a conventional class to fix the issue.

Here's the updated code:

```java
// Runtime: 34 ms (Top 94.1%) | Memory: 44.35 MB (Top 43.8%)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    class Node {
        int i;
        int t;

        public Node(int i, int t) {
            this.i = i;
            this.t = t;
        }
    }

    class Cell {
        int i;
        int t;
        int c;

        public Cell(int i, int t, int c) {
            this.i = i;
            this.t = t;
            this.c = c;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] fees) {
        int n = fees.length;

        // create the adjacency list graph
        List<Node>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (var e : edges) {
            g[e[0]].add(new Node(e[1], e[2]));
            g[e[1]].add(new Node(e[0], e[2]));
        }

        // Dijkstra
        Queue<Cell> q = new PriorityQueue<>((a, b) -> a.c == b.c ? a.t - b.t : a.c - b.c);
        int[] T = new int[n]; // 1. visited: de-dup 2. de-dup on worst time

        q.offer(new Cell(0, 0, fees[0]));
        Arrays.fill(T, maxTime + 1);
        T[0] = 0;

        while (!q.isEmpty()) {
            var cur = q.poll();
            if (cur.i == n - 1) return cur.c;

            for (var nei : g[cur.i]) {
                int t2 = cur.t + nei.t;
                if (t2 >= T[nei.i]) continue; // if time is worst, no reason to continue
                T[nei.i] = t2;
                q.offer(new Cell(nei.i, t2, cur.c + fees[nei.i]));
            }
        }

        return -1;
    }
}
```