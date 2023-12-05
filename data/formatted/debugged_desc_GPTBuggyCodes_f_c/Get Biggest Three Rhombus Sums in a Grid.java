```java
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] uniqueSums = new int[m * n][];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int s = 1; i + s - 1 < m && i - s + 1 >= 0 && j + 2 * s - 1 < n; s++) {
                    int sum = 0;
                    for (int k = 0; k < s; k++) { // upper border
                        sum += grid[i - k][j + k] + grid[i + k][j + k] + grid[i + s][j + s - k] + grid[i - s][j + s - k];
                    }
                    for (int k = 1; k < s; k++) { // subtract overlapping parts
                        sum -= grid[i - k][j + s - k] + grid[i - s + k][j + s - k] + grid[i - s + k][j - s + k] + grid[i + k][j - s + k];
                    }
                    uniqueSums[count] = new int[]{sum, i, j};
                    count++;
                }
            }
        }

        Arrays.sort(uniqueSums, (a, b) -> -Integer.compare(a[0], b[0])); // Sort in reverse order

        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < count && resultSet.size() < 3; i++) {
            resultSet.add(uniqueSums[i][0]);
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        return result;
    }
}
```