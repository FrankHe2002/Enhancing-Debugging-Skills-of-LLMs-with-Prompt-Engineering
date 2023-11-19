```java
// Runtime: 14 ms (Top 30.54%) | Memory: 57.2 MB (Top 69.94%)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int lo = 0, hi = rows - 1;  // Modified
        while (lo <= hi) {  // Modified
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] <= target) {
                lo = mid + 1;  // Modified
            } else {
                hi = mid - 1;  // Modified
            }
        }
        int[] prospect;
        for (int i = 0; i <= hi; i++) {  // Modified
            prospect = matrix[i];
            int l = 0;
            int h = cols - 1;  // Modified
            while (l <= h) {  // Modified
                int mid = l + (h - l) / 2;
                if (prospect[mid] <= target) {
                    l = mid + 1;  // Modified
                } else {
                    h = mid - 1;  // Modified
                }
            }
            if (h >= 0 && prospect[h] == target) {  // Modified
                return true;
            }
        }
        return false;
    }
}
```