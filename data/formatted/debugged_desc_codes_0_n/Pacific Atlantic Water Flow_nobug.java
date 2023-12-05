```java
// Runtime: 13 ms (Top 37.68%) | Memory: 54.9 MB (Top 45.37%)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return new ArrayList<>(); // Changed to return an empty list

        boolean[][] po = new boolean[heights.length][heights[0].length]; // no change
        boolean[][] ao = new boolean[heights.length][heights[0].length]; // no change

        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, po); // Changed 0 to Integer.MIN_VALUE
            dfs(heights, i, heights.length - 1, Integer.MIN_VALUE, ao); // Changed 0 to Integer.MIN_VALUE
        }

        for (int i = 0; i < heights.length; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, po); // Changed 0 to Integer.MIN_VALUE
            dfs(heights, heights[0].length - 1, i, Integer.MIN_VALUE, ao); // Changed 0 to Integer.MIN_VALUE
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (ao[i][j] && po[i][j]) {
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(i);
                    ar.add(j);
                    ans.add(ar);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, int x, int y, int h, boolean[][] v) {
        if (x < 0 || y < 0 || x >= heights[0].length || y >= heights.length) return;
        if (v[y][x] || heights[y][x] < h) return;
        v[y][x] = true;
        dfs(heights, x - 1, y, heights[y][x], v);
        dfs(heights, x + 1, y, heights[y][x], v);
        dfs(heights, x, y - 1, heights[y][x], v);
        dfs(heights, x, y + 1, heights[y][x], v);
    }
}
```