```java
// Runtime: 20 ms (Top 59.55%) | Memory: 62.3 MB (Top 88.99%)
class Solution {
    int[] arr;

    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < land.length; i++)
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    arr = new int[] {i, j, i, j};
                    dfs(land, i, j);
                    res.add(arr);
                }
            }
        return res.stream().toArray(int[][]::new);
    }

    public void dfs(int[][] land, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] == 0) return;
        arr[2] = Math.max(i, arr[2]);
        arr[3] = Math.max(j, arr[3]);
        arr[0] = Math.min(arr[0], i);
        arr[1] = Math.min(arr[1], j);
        land[i][j] = 0;
        dfs(land, i - 1, j);
        dfs(land, i, j + 1);
        dfs(land, i + 1, j);
        dfs(land, i, j - 1);
    }
}
```