// Runtime: 43 ms (Top 26.7%) | Memory: 43.29 MB (Top 18.2%)

class Solution {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> participants = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            participants.add(i);
        }

        int lastKilled = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < k-1; j++) {
                participants.add(participants.poll());
            }
            lastKilled = participants.poll();
        }
        return lastKilled;
    }
}