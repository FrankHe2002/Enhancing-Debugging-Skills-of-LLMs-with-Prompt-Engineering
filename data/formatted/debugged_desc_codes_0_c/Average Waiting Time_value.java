The bug in the given code is that it does not calculate the total time the customers have to wait before the chef starts preparing their order. The code is only calculating the total time taken to prepare the orders.

To fix the bug, the total waiting time for each customer must be calculated and then summed to find the average waiting time for all customers.

Here's the revised code with the fix:
```java
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double time = 0;
        double waitingTime = 0;

        for (int[] cust : customers) {
            time = Math.max(cust[0], time) + cust[1];
            waitingTime += (time - cust[0]);
        }

        return waitingTime / customers.length;
    }
}
```