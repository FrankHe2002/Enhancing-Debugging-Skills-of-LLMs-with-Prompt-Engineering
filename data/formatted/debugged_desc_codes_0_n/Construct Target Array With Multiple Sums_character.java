```java
// Runtime: 16 ms (Top 47.45%) | Memory: 56.9 MB (Top 77.47%)

class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;

        PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
        long totsum = 0; // Change int to long

        for (int i = 0; i < target.length; i++) {
            que.add(target[i]);
            totsum += target[i];
        }

        while (que.peek() != 1) {
            long max = que.remove(); // Change int to long
            long rem = totsum - max; // Change int to long
            long maxprev = max % rem; // Change int to long
            totsum = rem + maxprev;

            if (rem == 1) return true;

            if (maxprev == 0 || maxprev >= rem) { // Change maxprev == max to maxprev >= rem
                return false;
            } else {
                que.add((int)maxprev); // Cast maxprev to int
            }
        }

        return true;
    }
}
```