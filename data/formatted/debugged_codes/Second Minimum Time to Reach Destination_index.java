class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[] {1, 0});
        int[] uniqueVisit = new int[n + 1];
        int[] dis = new int[n + 1];
        Arrays.fill(dis, - 1);
        while (! q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], t = cur[1];
            if (dis[node] != - 1 || uniqueVisit[node] >= 2) continue;
            uniqueVisit[node]++;
            dis[node] = t;
            if (node == n && uniqueVisit[node] == 2) return dis[node];
            if ((t / change) % 2 != 0) t = (t / change + 1) * change;
            for (int nei : g.getOrDefault(node, new ArrayList<>())) {
                q.offer(new int[] {nei, t + time});
            }
        }
        return - 1;
    }
}