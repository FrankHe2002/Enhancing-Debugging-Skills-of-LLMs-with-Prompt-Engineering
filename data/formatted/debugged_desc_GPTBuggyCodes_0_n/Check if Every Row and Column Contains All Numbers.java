```java
import java.util.HashSet;

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int num = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> hs = new HashSet<Integer>();
            HashSet<Integer> hs1 = new HashSet<Integer>();

            int m = num;
            int k = num;

            for (int j = 0; j < n; j++) {
                hs.add(matrix[i][j]);
                hs1.add(matrix[j][i]);
                m -= matrix[i][j];
                k -= matrix[j][i];
            }

            if (m != 0 || k != 0 || hs.size() != n || hs1.size() != n) {
                return false;
            }
        }
        return true;
    }
}
```