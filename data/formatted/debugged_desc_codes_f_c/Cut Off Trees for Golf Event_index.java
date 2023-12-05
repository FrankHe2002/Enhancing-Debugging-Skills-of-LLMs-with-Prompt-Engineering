Buggy Java Code:
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
            if (dis == - 1)
                return - 1;
            ans += dis;
            curr = temp;
        }
        return ans;
    }

    int calcDis(List<List<Integer>> forest, int start[], int end[]) {
        int n = forest.size(), m = forest.get(0).size();
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        vis[start[0]][start[1]] = true;
        int dis = 0;
        while (queue.size() > 0) {
            int len = queue.size();
            while (len-- > 0) {
                int temp[] = queue.remove();
                int r = temp[0], c = temp[1];
                if (r == end[0] && c == end[1])
                    return dis;
                if (r + 1 < n && ! vis[r + 1][c + 2] && forest.get(r + 1).get(c) != 0) {
                    queue.add(new int[] {r + 1, c});
                    vis[r + 1][c] = true;
                }
                if (r - 1 >= 0 && ! vis[r - 1][c] && forest.get(r - 1).get(c) != 0) {
                    queue.add(new int[] {r - 1, c});
                    vis[r - 1][c] = true;
                }
                if (c - 1 >= 0 && ! vis[r][c - 1] && forest.get(r).get(c - 1) != 0) {
                    queue.add(new int[] {r, c - 1});
                    vis[r][c - 1] = true;
                }
                if (c + 1 < m && ! vis[r][c + 1] && forest.get(r).get(c + 1) != 0) {
                    queue.add(new int[] {r, c + 1});
                    vis[r][c + 1] = true;
                }
            }
            dis++;
        }
        return - 1;

    }
}
```


Fix:
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
        int[][] dirs = {{1, 0}, {-1, 0},{0, -1},{0, 1}};
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                int[] temp = queue.poll();
                int r = temp[0], c = temp[1];
                if (r == end[0] && c == end[1])
                    return dis;
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && forest.get(nr).get(nc) != 0) {
                        queue.add(new int[]{nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
            dis++;
        }
        return -1;

    }
}
```