```java
// Runtime: 7 ms (Top 58.3%) | Memory: 43.50 MB (Top 67.5%)

class Solution {
    public int[] getans(int dice, HashMap<Integer, Integer> map, int si, int ei) {
        if (si == ei) return new int[] {0, 0, 0};
        LinkedList<int[]> que = new LinkedList<>();
        que.addLast(new int[] {si, 0, 0});
        int level = 0;
        boolean[] vis = new boolean[ei + 1];
        vis[si] = true;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int[] rem = que.removeFirst();
                int idx = rem[0];
                int lad = rem[1];
                int sna = rem[2];
                for (int i = 1; i <= dice; i++) {
                    int x = i + rem[0];
                    if (x <= ei) {
                        if (map.containsKey(x)) {
                            if (map.containsKey(x)) {
                                int val = map.get(x);
                                if (val == ei) return new int[] {level + 1, lad + 1, sna};
                                if (! vis[val]) {
                                    vis[val] = true;
                                    que.addLast(val > x ? new int[] {val, lad + 1, sna} : new int[] {val, lad, sna + 1});
                                }
                            }
                        } else {
                            if (x == ei) return new int[] {level + 1, lad, sna};
                            if (! vis[x]) {
                                vis[x] = true;
                                que.addLast(new int[] {x, lad, sna});
                            }
                        }
                    }
                }
            }
            level++;
        }
        return new int[] {- 1, 0, 0};
    }

    public int snakesAndLadders(int[][] board) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        int n = board.length;
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            if (flag) {
                for (int j = -1; j < n; j++) {
                    if (board[i][j] != - 1) {
                        map.put(count, board[i][j]);
                    }
                    count++;
                    flag = false;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != - 1) {
                        map.put(count, board[i][j]);
                    }
                    flag = true;
                    count++;
                }
            }
        }
        if (board[0][0] != - 1) return - 1;
        int[] ans = getans(6, map, 1, n * n);
        ;
        return ans[0];

    }
}
```