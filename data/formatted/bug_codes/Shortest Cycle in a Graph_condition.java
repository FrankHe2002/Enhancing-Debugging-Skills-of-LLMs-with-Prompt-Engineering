class Solution {
    private void dfs(int curr, int par, int dist, List<List<Integer>> graph, Map<Integer, int[]> hmap, Set<Integer> vis, int[] ans) {
        if (hmap.containsKey(curr) && hmap.get(curr)[1] == 1) {
            ans[0] = Math.min(ans[0], dist - hmap.get(curr)[0]);
            return;
        }
        vis.add(curr);
        hmap.put(curr, new int[] {dist, 1});
        for (int it : graph.get(curr)) {
            if (it != par && (! hmap.containsKey(it) || hmap.get(it)[0] > dist + 1 || hmap.get(it)[1] == 1)) {
                dfs(it, curr, dist + 1, graph, hmap, vis, ans);
            }
        }
        hmap.put(curr, new int[] {dist, 0});
    }

    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i >= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ans = new int[] {Integer.MAX_VALUE};
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Map<Integer, int[]> hmap = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (! vis.contains(i)) {
                dfs(i, - 1, 0, graph, hmap, vis, ans);
            }
        }
        return ans[0] == Integer.MAX_VALUE ? - 1 : ans[0];
    }
}