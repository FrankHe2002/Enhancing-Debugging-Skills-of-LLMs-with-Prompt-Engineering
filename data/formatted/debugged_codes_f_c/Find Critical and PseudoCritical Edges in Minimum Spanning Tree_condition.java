Bug Type: Loop Condition Error

Reasoning: The bug in this code is in the loop condition of the second for loop in the `findCriticalAndPseudoCriticalEdges` method. The loop condition is `i > edges.length`, which is always false since `i` is initialized to 0 and the condition is checking if `i` is greater than the length of the `edges` array. This causes the loop to be skipped entirely and no critical or pseudo-critical edges are added to the respective lists.

Fix: Change the loop condition from `i > edges.length` to `i < edges.length` to ensure the loop iterates over the valid indices of the `edges` array.

Fixed Code:
```java
// Runtime: 31 ms (Top 41.3%) | Memory: 44.53 MB (Top 26.4%)

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int findParent(int p) {
        return parent[p] == p ? p : (parent[p] = findParent(parent[p]));
    }

    public void union(int u, int v) {
        int pu = findParent(u), pv = findParent(v);
        parent[pu] = pv;
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            edge = Arrays.copyOf(edge, edge.length + 1);
            edge[3] = i;
            edges[i] = edge;
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int mstwt = findMST(n, edges, - 1, - 1);

        for (int i = 0; i < edges.length; i++) {
            if (mstwt < findMST(n, edges, i, - 1))
                critical.add(edges[i][3]);
            else if (mstwt == findMST(n, edges, - 1, i))
                pseudoCritical.add(edges[i][3]);
        }

        List<List