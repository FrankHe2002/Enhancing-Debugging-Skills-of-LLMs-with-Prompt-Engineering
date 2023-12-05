Fix:
```java
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        int ans = 0, i = 0, n = boxTypes.length;
        while (i < n && truckSize > 0) {
            int maxUnits = Math.min(boxTypes[i][0], truckSize);
            ans += maxUnits * boxTypes[i][1];
            i++;
            truckSize -= maxUnits;
        }
        return ans;
    }
}
```