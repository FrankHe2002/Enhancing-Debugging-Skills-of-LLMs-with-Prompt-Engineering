The main bug which can be spotted is that the condition should be `if (distance != 0)` instead of `if (distance > 0)`. This is because we want to count the instances where the distance is non-zero and not just positive.

Here is the corrected code:

```java
import java.util.HashMap;

class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int answer = 0;

        for (int p = 0; p < points.length; p++) {

            int[] i = points[p];

            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();

            for (int q = 0; q < points.length; q++) {

                if (q == p) {
                    continue;
                }

                int[] j = points[q];

                double distance = Math.sqrt(Math.pow(j[0] - i[0], 2) + Math.pow(j[1] - i[1], 2));

                if (distance != 0) {
                    if (hm.containsKey(distance)) {
                        hm.put(distance, hm.get(distance) + 1);
                    } else {
                        hm.put(distance, 1);
                    }
                }
            }

            for (double dist : hm.keySet()) {
                int occ = hm.get(dist);
                if (occ > 1) {
                    answer += occ * (occ - 1);
                }
            }
        }

        return answer;
    }
}
```