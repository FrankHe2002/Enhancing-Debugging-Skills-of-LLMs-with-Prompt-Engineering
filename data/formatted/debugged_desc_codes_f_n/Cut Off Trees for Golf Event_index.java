```java
// Runtime: 273 ms (Top 92.8%) | Memory: 44.58 MB (Top 18.0%)

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1])));
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1)
                    pq.add(new int[] {i, j});
            }
        }
        int ans = 0;
        int[] curr = {0, 0};
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int dis = calcDis(forest, curr, temp);
            if (dis == -1)
                return -1;
            ans += dis;
            curr = temp;
        }
        return ans;
    }

    int calcDis(List<List<Integer>> forest, int[] start, int[] end) {
        int n = forest.size(), m = forest.get(0).size();
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        vis[start[0]][start[1]] = true;
        int dis = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] temp = queue.poll();
                int r = temp[0], c = temp[1];
                if (r == end[0] && c == end[1])
                    return dis;
                for (int[] d : dir) {
                    int dr = r + d[0];
                    int dc = c + d[1];
                    if (dr >= 0 && dr < n && dc >= 0 && dc < m && !vis[dr][dc] && forest.get(dr).get(dc) != 0) {
                        queue.add(new int[]{dr, dc});
                        vis[dr][dc] = true;
                    }
                }
            }
            dis++;
        }
        return -1;
    }
}
```