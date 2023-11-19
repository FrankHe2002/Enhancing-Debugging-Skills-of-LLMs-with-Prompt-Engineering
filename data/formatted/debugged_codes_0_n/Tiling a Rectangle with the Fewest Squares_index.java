```java
class Solution {
    int ret;
    int m, n;

    public int tilingRectangle(int m, int n) {
        this.m = m;
        this.n = n;
        this.ret = m * n;
        int[][] mat = new int[m][n];
        backtrack(mat, 0);
        return ret;
    }

    public void backtrack(int[][] mat, int size) {
        if (size > ret) return;

        int x = -1, y = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x != -1 && y != -1) break;
        }

        if (x == -1 && y == -1) {
            ret = Math.min(size, ret);
        } else {
            int len = findWidth(x, y, mat);
            while (len >= 1) {
                cover(x, y, len, mat, 1);
                backtrack(mat, size + 1);
                cover(x, y, len, mat, 0);
                len--;
            }
        }
    }

    public int findWidth(int x, int y, int[][] mat) {
        int len = 1;
        while (x + len < m && y + len < n) {
            boolean flag = true;
            for (int i = 0; i <= len; i++) {
                if (mat[x + i][y + len] == 1 || mat[x + len][y + i] == 1) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            len++;
        }
        return len;
    }

    public void cover(int x, int y, int len, int[][] mat, int val) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                mat[i][j] = val;
            }
        }
    }
}
```