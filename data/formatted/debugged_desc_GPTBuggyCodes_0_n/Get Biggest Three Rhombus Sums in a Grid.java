```java
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int end = Math.min(grid.length, grid[0].length);
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int length = 0; length < end; length++) {
            searchBigThree(grid, set, length);
        }

        int size = Math.min(3, set.size());
        int[] maxThree = new int[size];
        
        for (int i = 0; i < size; i++) {
            maxThree[i] = set.pollLast();
        }

        return maxThree;
    }

    void searchBigThree(int[][] grid, TreeSet<Integer> set, int length) {
        int end = grid.length - (length == 0 ? 0 : 2 * length);
        int end1 = grid[0].length - (length);
        
        for (int start = 0; start < end; start++) {
            for (int start1 = length; start1 < end1; start1++) {
                if (start + start1 >= length) {
                    set.add(getSum(grid, start, start1, length));
                }
            }
        }
    }

    int getSum(int[][] grid, int i, int j, int length) {
        if (length == 0) {
            return grid[i][j];
        }

        int sum = 0;
        for (int it = 0; it <= length; it++) {
            sum = sum + grid[i + it][j + it];
        }
        for (int it = 1; it <= length; it++) {
            sum = sum + grid[i + it][j - it];
        }
        for (int it = 1; it <= length; it++) {
            sum = sum + grid[i + length + it][j - length + it];
        }
        for (int it = 1; it < length; it++) {
            sum = sum + grid[i + length + it][j + length - it];
        }

        return sum;
    }
}
```