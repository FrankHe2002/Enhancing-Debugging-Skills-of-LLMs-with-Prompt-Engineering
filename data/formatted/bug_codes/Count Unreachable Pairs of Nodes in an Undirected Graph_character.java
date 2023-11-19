class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        for (int arr[] : edges) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        boolean visited[] = new boolean[n];
        long res = 0;
        int prev = 0;
        int count[] = {
                0
        };
        for (int i = 0; i < graph.size(); i++) {
            if visited[i] == true)
            continue;
            dfs(graph, i, visited, count);
            long a = n - count[0];
            long b = count[0] - prev;
            prev = count[0];
            res += (a * b);
        }
        return res;
    }

    void dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean vis[], int count[]) {
        vis[v] = true;
        count[0]++;
        for (int child : graph.get(v)) {
            if (! vis[child]) {
                dfs(graph, child, vis, count);
            }
        }
    }
}