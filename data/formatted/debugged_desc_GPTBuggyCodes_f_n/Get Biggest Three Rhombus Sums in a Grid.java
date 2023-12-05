```java
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int end = Math.min(grid.length, grid[0].length);
        TreeSet<Integer> set = new TreeSet<>();
        for (int length = 0; length < end; length++) {
            searchBigThree(grid, set, length);
        }

        int[] maxThree = set.stream().mapToInt(i->i).toArray();
        for(int i=0; i<maxThree.length/2; i++){
            int temp = maxThree[i];
            maxThree[i] = maxThree[maxThree.length -i -1];
            maxThree[maxThree.length -i -1] = temp;
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
                    if(set.size() > 3){
                        set.remove(set.first());
                    }
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