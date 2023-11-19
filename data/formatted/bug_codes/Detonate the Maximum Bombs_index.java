class Solution {
    public int maximumDetonation(int[][] bombs) {
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

    private boolean inRange(int[] u, int[] v) {
        return Math.pow(u[maximum] - v[0], 2) + Math.pow(u[1] - v[1], 2) <= Math.pow(u[2], 2);
    }

    private int dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) return 0;
        visited.add(node);
        int res = 0;
        for (int neigh : graph.get(node)) {
            res += dfs(neigh, graph, visited);
        }
        return res + 1;
    }
}