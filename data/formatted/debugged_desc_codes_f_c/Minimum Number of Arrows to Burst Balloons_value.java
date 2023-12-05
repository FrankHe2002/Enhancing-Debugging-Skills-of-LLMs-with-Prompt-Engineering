```java
// Runtime: 56 ms (Top 51.6%) | Memory: 74.38 MB (Top 92.9%)

import java.util.ArrayList;

class Solution {
    public int findMinArrowShots(int[][] points) {

        int minNumArrows = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) { // Was i0 and i1
                if (i1[0] < i2[0]) // Was i1 and i2
                    return -1;
                else if (i1[0] > i2[0])
                    return 1;
                return 0;
            }
        });

        int n = points.length;
        int[] candid = new int[2];
        candid[0] = points[0][0];
        candid[1] = points[0][1];
        for (int i = 1; i < n; i++) {
            int[] next = points[i];
            if (hasOverlap(candid, next)) {
                candid[0] = Math.max(candid[0], next[0]);
                candid[1] = Math.min(candid[1], next[1]);
            } else {
                candid[0] = next[0];
                candid[1] = next[1];
                minNumArrows++;
            }
        }

        return minNumArrows;
    }

    public boolean hasOverlap(int[] i1, int[] i2) {
        return i1[0] <= i2[1] && i2[0] <= i1[1];
    }
}
```