```java
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
        int curr[] = {0, 0};
        while (pq.size() > 0) {
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
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                int[] temp = queue.remove();
                int r = temp[0], c = temp[1];
                if (r == end[0] && c == end[1])
                    return dis;
                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if (newR >= 0 && newR < n && newC >= 0 && newC < m && !vis[newR][newC] && forest.get(newR).get(newC) != 0) {
                        queue.add(new int[] {newR, newC});
                        vis[newR][newC] = true;
                    }
                }
            }
            dis++;
        }
        return -1;

    }
}
```