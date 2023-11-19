```java
import java.util.HashMap;

class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        int row = grid.length;
        int col = grid[0].length; // Fixed bug: should use grid[0].length instead of grid.length
        for (int i = 0; i < row; i++) {
            String res = "";
            for (int j = 0; j < col; j++) {
                res += "-" + grid[i][j];
            }
            map.put(res, map.getOrDefault(res, 0) + 1);
        }
        int cnt = 0;
        for (int j = 0; j < col; j++) { // Fixed bug: should use j < col instead of j >= col
            String res = "";
            for (int i = 0; i < row; i++) {
                res += "-" + grid[i][j];
            }
            cnt += map.getOrDefault(res, 0);
        }
        return cnt;
    }
}
```