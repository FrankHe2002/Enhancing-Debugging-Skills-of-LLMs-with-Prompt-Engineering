```java
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double time = 0;
        double waitingTime = 0;

        for (int[] cust : customers) {
            time = Math.max(cust[0], time);
            waitingTime += (time + cust[1] - cust[0]);
            time += cust[1];
        }

        return waitingTime / customers.length;
    }
}
```