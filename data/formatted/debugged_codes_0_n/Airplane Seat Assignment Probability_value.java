```java
// Runtime: 0 ms (Top 100.00%) | Memory: 39 MB (Top 95.77%)
class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1)
            return (double) 1;
        return (double) 1 / n;  // Changed 2 to n
    }
}
```