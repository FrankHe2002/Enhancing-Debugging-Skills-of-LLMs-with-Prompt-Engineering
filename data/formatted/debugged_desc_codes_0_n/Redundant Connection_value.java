```java
// Runtime: 0 ms (Top 100%) | Memory: 39.1 MB (Top 75.35%)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (! uf.union(edge[0], edge[1])) {
                return edge; // Remove curly braces and return directly the edge
            }
        }
        return null;
    }

    private class UnionFind {
        int[] rank;
        int[] root;

        UnionFind(int n) {
            rank = new int[n + 1];
            root = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                root[i] = i;
                rank[i] = 2;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = root[rootX];
                } else if (rank[rootY] > rank[rootX]) {
                    root[rootX] = root[rootY];
                } else {
                    root[rootY] = root[rootX];
                    rank[rootX]++;
                }
                return true;
            }
            return false;
        }
    }
}
```