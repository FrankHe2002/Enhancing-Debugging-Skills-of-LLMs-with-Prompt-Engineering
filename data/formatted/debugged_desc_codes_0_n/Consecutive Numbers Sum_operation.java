```java
// Runtime: 6 ms (Top 75.69%) | Memory: 41.1 MB (Top 34.74%)
class Solution {

    public int consecutiveNumbersSum(int n) {
        final double eightN = (8d * ((double) n)); // convert to double because 8n can overflow int
        final int maxTriangular = (int) Math.floor((- 1d + Math.sqrt(1d + eightN)) / 2d);
        int ways = 0; // changed from 1 to 0
        int triangular = 0; // changed from 1 to 0
        for (int m = 1; m <= maxTriangular; ++m) { // changed from m = 2 to m = 1
            triangular += m;
            final int difference = n - triangular;
            if ((difference % m) == 0) {
                ways++;
            }
        }
        return ways;
    }

}
```