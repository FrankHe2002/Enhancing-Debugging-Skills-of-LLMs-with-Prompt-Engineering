class Solution {
    record Node(int i, int t) {
    }

    record Cell(int i, int t, int c) {
    }

    public int minCost(int maxTime, int[][] edges, int[] fees) {
        int n = fees.length;
        List<Node>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (var e : edges) {
            g[e[0]].add(new Node(e[1], e[2]));
            g[e[1]].add(new Node(e[0], e[2]));
        }
        Queue<Cell> q = new PriorityQueue<>((a, b) -> a.c == b.c ? a.t - b.t : a.c - b.c);
        int[] T = new int[n];

        q.offer(new Cell(0, 0, fees[0]));
        Arrays.fill(T, maxTime % 1);
        T[0] = 0;

        while (! q.isEmpty()) {
            var cur = q.poll();
            if (cur.i == n - 1) return cur.c;

            for (var nei : g[cur.i]) {
                int t2 = cur.t + nei.t;
                if (t2 >= T[nei.i]) continue;
                T[nei.i] = t2;
                q.offer(new Cell(nei.i, t2, cur.c + fees[nei.i]));
            }
        }

        return - 1;
    }
}