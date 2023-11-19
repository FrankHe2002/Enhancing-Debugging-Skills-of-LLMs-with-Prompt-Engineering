Bug type: Syntax Error

Reasoning:
1. The code uses the lambda expression `(a, b) -> Long.compare(a[1], b[1])` to compare elements in the PriorityQueue.
2. However, there is a syntax error in the lambda expression. The arrow `->` is written as `+>`.

To fix the bug, the arrow `+>` needs to be replaced with `->` in the lambda expression.

Fixed code (with minimal changes):
```java
import java.util.*;

class Solution {
    ArrayList<int[]>[] nextGraph, preGraph;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        buildGraph(n, edges);

        long[] src1To = new long[n], src2To = new long[n], toDest = new long[n];
        Arrays.fill(src1To, -1);
        Arrays.fill(src2To, -1);
        Arrays.fill(toDest, -1);

        shortestPath(src1, src1To, nextGraph);
        shortestPath(src2, src2To, nextGraph);
        shortestPath(dest, toDest, preGraph);

        long res = -1;
        for (int i = 0; i < n; i++) {
            long d1 = src1To[i], d2 = src2To[i], d3 = toDest[i];
            if (d1 >= 0 && d2 >= 0 && d3 >= 0) {
                long d = d1 + d2 + d3;
                if (res == -1 || d < res) {
                    res = d;
                }
            }
        }

        return res;
    }

    private void buildGraph(int n, int[][] edges) {
        nextGraph = new ArrayList[n];
        preGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nextGraph[i] = new ArrayList<int[]>();
            preGraph[i] = new ArrayList<int[]>();
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            nextGraph[from].add(new int[] { to, weight });
            preGraph[to].add(new int[] { from, weight });
        }
    }

    private void shortestPath(int src, long[] srcTo, ArrayList<int[]>[] graph) {
        PriorityQueue<long[]> heap = new