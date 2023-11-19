// Runtime: 12 ms (Top 42.86%) | Memory: 54.9 MB (Top 45.37%)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null) return null;
        if (heights.length == 0) return null;
        if (heights[0].length == 0) return null;

        boolean[][] po = new boolean[heights.length][heights[0].length];
        boolean[][] ao = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, po); // top
            dfs(heights, i, heights.length - 1, Integer.MIN_VALUE, ao); // bottom
        }

        for (int i = 0; i < heights.length; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, po); // left
            dfs(heights, heights[0].length - 1, i, Integer.MIN_VALUE, ao); // right
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

    private void dfs(int[][] heights, int x, int y, int prev, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= heights[0].length || y >= heights.length) return;
        if (visited[y][x] || heights[y][x] < prev) return;
        visited[y][x] = true;
        
        dfs(heights, x - 1, y, heights[y][x], visited); // left
        dfs(heights, x + 1, y, heights[y][x], visited); // right
        dfs(heights, x, y - 1, heights[y][x], visited); // up