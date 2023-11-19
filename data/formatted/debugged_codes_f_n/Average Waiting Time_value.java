```java
// Runtime: 2 ms (Top 98.77%) | Memory: 58.3 MB (Top 47.63%)
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double time = 0;
        double waitingTime = 0;

        for (int[] cust : customers) {
            if (cust[0] > time) {
                time = cust[0];
            }
            time += cust[1];
            waitingTime += (time - cust[0]);
        }

        return waitingTime / customers.length;
    }
}
```