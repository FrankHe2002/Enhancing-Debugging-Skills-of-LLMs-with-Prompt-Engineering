BUG TYPE: Array Index Out of Bounds

REASONING:
1. The code is iterating through the elements of the `land` array using two nested loops.
2. Inside the loops, it checks if the current element (land[i][j + 1]) is equal to 1.
3. If the condition is true, it updates the `arr` array and performs a depth-first search (DFS).
4. The DFS modifies the `land` array and recursively explores neighboring cells.
5. The bug occurs when the loop variable `j` reaches the last column of the `land` array, and the code attempts to access land[i][j + 1].
6. Since j is already at the last column, j + 1 is out of bounds for the array.
7. This bug causes an ArrayIndexOutOfBoundsException to be thrown at runtime.

FIX:
To fix the bug, we need to modify the loop condition for the `j` variable to loop until j < land[0].length - 1 instead of j < land[0].length. This ensures that the code does not attempt to access an out-of-bounds element in the last column.

```java
// Runtime: 20 ms (Top 59.55%) | Memory: 62.3 MB (Top 88.99%)
class Solution {
    int[] arr;

    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < land.length; i++)
            for (int j = 0; j < land[0].length - 1; j++) {
                if (land[i][j + 1] == 1) {
                    arr = new int[] {i, j, 0, 0};
                    dfs(land, i, j);
                    res.add(arr);
                }
            }
        return res.stream().map(i -> i).toArray(int[][]::new);
    }

    public void dfs(int[][] land, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] == 0) return;
        arr[2] = Math.max(i, arr[2]);
        arr[3] = Math.max(j, arr[3]);
        land[i][j] = 0;
        dfs(land, i - 1, j);
        dfs