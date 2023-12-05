The issue with the code seems to be a syntax error in the line:
```java
if ((t / change % 2 != 0) t = (t / change + 1) * change;
```
The conditional check in the if statement is missing a comparison operator, and there's a missing colon after the condition. To fix this bug, we need to add the comparison operator and a colon at the end of the if statement.

Additionally, there's a missing closing parenthesis for the if-statement condition. This might be a typo error. It should be fixed.

Here's the modified code with the fix:
```java
if ((t / change) % 2 != 0) {
    t = ((t / change) + 1) * change;
}
```

The modified and fixed Java code:
```java
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> g = new HashMap();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, x -> new ArrayList()).add(v);
            g.computeIfAbsent(v, x -> new ArrayList()).add(u);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{1, 0});
        int[] uniqueVisit = new int[n + 1]; // uniqueVisit limit to 2 <==> relax twice at most
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        while (!q.isEmpty()) {
            int size = q.size();
            int[] cur = q.poll();
            int node = cur[0], t = cur[1]; // arriving time
            if (dis[node] == t || uniqueVisit[node] >= 2) continue; // skip if it's the same value or has been relaxed twice already
            uniqueVisit[node]++;
            dis[node] = t;
            if (node == n && uniqueVisit[node] == 2) return dis[node];
            // generate leaving time (waiting for the green light)
            if ((t / change) % 2 != 0) {
                t = ((t / change) + 1) * change;
            }
            for (int nei : g.getOrDefault(node, new ArrayList<>())) {
                q.offer(new int[]{nei, t + time});
            }
        }
        return -1;
    }
}
```