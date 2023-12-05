```java
// Runtime: 97 ms (Top 78.77%) | Memory: 112.4 MB (Top 41.18%)
class TreeAncestor {
    int n;
    int[] parent;
    ArrayList<Integer>[] nodeInPath;
    int[] nodeIdxInPath;

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
        nodeInPath = new ArrayList[n]; 
        nodeIdxInPath = new int[n];
        fill();
    }

    private void fill() {
        boolean[] inner = new boolean[n];
        for (int i = 1; i < n; i++) {
            inner[parent[i]] = true;
        }
        
        for (int i = 1; i < n; i++) {
            if (inner[i] || nodeInPath[i] != null) {
                continue;
            }
            ArrayList<Integer> path = new ArrayList<>();
            int k = i;
            while (k != -1) {
                path.add(k);
                k = parent[k];
            }
            int m = path.size();
            for (int j = 0; j < m; j++) {
                int node = path.get(j);
                if (nodeInPath[node] != null) {
                    break;
                }
                nodeInPath[node] = path;
                nodeIdxInPath[node] = j;
            }
        } 
    }

    public int getKthAncestor(int node, int k) {
        ArrayList<Integer> path = nodeInPath[node];
        int idx = nodeIdxInPath[node] + k;
        return idx >= path.size() ? -1 : path.get(idx);
    }
}
```