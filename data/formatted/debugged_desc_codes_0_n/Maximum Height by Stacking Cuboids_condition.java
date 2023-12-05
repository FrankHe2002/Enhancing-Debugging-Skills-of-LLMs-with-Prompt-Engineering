```java
// Runtime: 9 ms (Top 37.8%) | Memory: 41.26 MB (Top 83.6%)

class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] arr : cuboids) Arrays.sort(arr);
        Arrays.sort(cuboids, (a, b) -> (b[2] - a[2] == 0 ? (b[1] - a[1] == 0 ? b[0] - a[0] : b[1] - a[1]) : b[2] - a[2]));
        return helperTab(cuboids);
    }

    public int helperTab(int[][] cuboids) {
        int n = cuboids.length;
        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= - 1; prev--) {
                int take = 0;
                if (prev == -1 || check(cuboids[curr], cuboids[prev])) take = cuboids[curr][2] + nextRow[curr + 1];
                int notTake = 0 + nextRow[prev + 1];
                currRow[prev + 1] = Math.max(take, notTake);
            }
            nextRow = currRow.clone();
        }
        return nextRow[0];
    }

    public boolean check(int[] a, int[] b) {
        if (a[0] <= b[0] && a[1] <= b[1] && a[2] <= b[2]) return true;
        else return false;
    }
}
```