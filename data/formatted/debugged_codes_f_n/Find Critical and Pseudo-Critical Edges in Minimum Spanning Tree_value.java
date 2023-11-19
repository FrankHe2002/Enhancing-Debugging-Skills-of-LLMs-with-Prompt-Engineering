```java
class Solution {
    static class UnionFind {
        int[] parent;
        int[] rank;
        int comp = 0;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            comp = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        boolean union(int X, int Y) {
            int x = find(X);
            int y = find(Y);
            if (x == y) {
                return false;
            }

            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[y] < rank[x]) {
                parent[y] = x;
            } else {
                parent[y] = x;
                rank[x]++;
            }
            comp--;
            return true;
        }

        boolean isConnected() {
            return comp == 1;
        }

    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public int buildMST(int n, int[][] edges, int[] edgeSkip, int[] edgePick) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int[] edge : edges) {
            if (edge == edgeSkip) {
                continue;
            } else if (edge == edgePick) {
                continue;
            }
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            pq.add(new Edge(u, v, wt));
        }

        UnionFind uf = new UnionFind(n);
        int cost = 0;

        if (edgePick != null) {
            uf.union(edgePick[0], edgePick[1]);
            cost += edgePick[2];
        }
        while (pq.size() > 0) {
            Edge rem = pq.remove();
            if (uf.union(rem.u,