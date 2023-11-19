```java
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> {
            return b[0] - a[0];
        });

        int[] parentAlice = new int[n + 1];
        int[] parentBob = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parentAlice[i] = i;
            parentBob[i] = i;
        }

        int mergeAlice = 1;
        int mergeBob = 1;

        int removeEdge = 0;

        for (int[] edge : edges) {
            int cat = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (cat == 3) {
                boolean tempAlice = union(u, v, parentAlice);
                boolean tempBob = union(u, v, parentBob);

                if (tempAlice == true)
                    mergeAlice += 1;

                if (tempBob == true)
                    mergeBob += 1;

                if (tempAlice == false && tempBob == false)
                    removeEdge += 1;
            } else if (cat == 2) {
                boolean tempBob = union(u, v, parentBob);

                if (tempBob == true)
                    mergeBob += 1;
                else
                    removeEdge += 1;
            } else {
                boolean tempAlice = union(u, v, parentAlice);

                if (tempAlice == true)
                    mergeAlice += 1;
                else
                    removeEdge += 1;
            }
        }
        if (mergeAlice != n || mergeBob != n)
            return - 1;
        return removeEdge;
    }

    public int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;

        return find(parent[x], parent);
    }

    public boolean union(int x, int y, int[] parent) {
        int lx = find(x, parent);
        int ly = find(y, parent);

        if (lx != ly) {
            parent[lx] = ly;

            return true;
        } else
            return false;
    }
}
```