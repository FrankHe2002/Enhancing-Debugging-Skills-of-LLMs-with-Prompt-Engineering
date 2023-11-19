class Solution {
    public double averageWaitingTime(int[][] customers) {
        double time = 0;
        double waitingTime = 0;

        for (int[] cust : customers) {
            time = Math.max(cust[1], time);
            time = time + cust[2];
            waitingTime += (time - cust[0]);
        }

        return waitingTime / customers.length;
    }
}