```java
class Solution {

    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> rank;
    private Map<Pair<Integer, Integer>, Integer> edgesRank;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        this.formGraph(n, connections);
        this.dfs(0, 0);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Pair<Integer, Integer> criticalConnection : this.edgesRank.keySet()) {
            if (this.edgesRank.get(criticalConnection) > this.rank.get(criticalConnection.getValue())) {
                result.add(new ArrayList<Integer>(Arrays.asList(criticalConnection.getKey(), criticalConnection.getValue())));
            }
        }

        return result;
    }

    private int dfs(int node, int discoveryRank) {

        // That means this node is already visited. We simply return the rank.
        if (this.rank.get(node) != null) {
            return this.rank.get(node);
        }

        // Update the rank of this node.
        this.rank.put(node, discoveryRank);

        // This is the max we have seen till now. So we start with this instead of INT_MAX or something.
        int minRank = discoveryRank;

        for (Integer neighbor : this.graph.get(node)) {

            // Skip the parent.
            Integer neighRank = this.rank.get(neighbor);
            if (neighRank != null && neighRank == discoveryRank - 1) {
                continue;
            }

            // Recurse on the neighbor.
            int recursiveRank = this.dfs(neighbor, discoveryRank + 1);

            // Update the minRank if needed.
            minRank = Math.min(minRank, recursiveRank);
        }
        
        this.edgesRank.put(new Pair<Integer, Integer>(node, this.graph.get(node).get(0)), minRank);
        
        return minRank;
    }

    private void formGraph(int n, List<List<Integer>> connections) {

        this.graph = new HashMap<Integer, List<Integer>>();
        this.rank = new HashMap<Integer, Integer>();
        this.edgesRank = new HashMap<Pair<Integer, Integer>, Integer>();

        // Default rank for unvisited nodes is "null"
        for (int i = 0; i < n; i++) {
            this.graph.put(i, new ArrayList<Integer>());
            this.rank.put(i, null);
        }

        for (List<Integer> edge : connections) {

            // Bidirectional edges
            int u = edge.get(0), v = edge.get(1);
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);
        }
    }
}
```