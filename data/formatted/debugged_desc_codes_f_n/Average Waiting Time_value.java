```java
// Runtime: 13 ms (Top 47.13%) | Memory: 38.8 MB (Top 88.44%)
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double time = 0;
        double waitingTime = 0;

        for (int[] cust : customers) {
            time = Math.max(cust[0], time);
            time += cust[1];
            waitingTime += (time - cust[0]);
        }

        return waitingTime / customers.length;
    }
}
```