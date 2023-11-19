import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] dist = dijkstra(adj);
        int ans = 0;
        for (int x = 1; x < n; x++) {
            int time = 2 * dist[x];

            int p = patience[x];
            int numberOfMessagesSent = (time) / p;
            if (time % p == 0) {
                numberOfMessagesSent--;
            }
            int lastMessage = numberOfMessagesSent * p;
            ans = Math.max(ans, lastMessage + 2 * dist[x] + 1);

        }

        return ans;
    }

    private int[] dijkstra(ArrayList<ArrayList<Integer>> adj) {

        int n = adj.size();

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        pq.add(new int[] {0, 0});

        while (! pq.isEmpty()) {