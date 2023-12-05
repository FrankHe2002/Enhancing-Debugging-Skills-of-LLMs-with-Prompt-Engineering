```java
// Runtime: 43 ms (Top 26.7%) | Memory: 43.29 MB (Top 18.2%)

class Solution {
    public int findTheWinner(int n, int k) {
        // Initialisation of the LinkedList
        LinkedList<Integer> participants = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            participants.add(i);
        }

        int lastKilled = 0;
        // Run the game
        int index = 0;
        while (n > 1) {
            index = (index + k - 1) % n;
            lastKilled = participants.remove(index);
            n--;
        }
        // Return the last one killed
        return lastKilled;
    }
}
```