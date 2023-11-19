```java
// Runtime: 1 ms (Top 99.97%) | Memory: 39.4 MB (Top 79.99%)

class Solution {
    public int maxDistToClosest(int[] seats) {
        int size = seats.length;
        int max = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < size; i++) {
            if (seats[i] != 0) {
                start = end;
                end = i;
                if (start == -1) {
                    max = i;
                } else {
                    max = Math.max((end - start) / 2, max);
                }
            }
        }

        if (seats[size - 1] == 0 || start == -1) {
            return Math.max(max, (size - 1 - end));
        }
        return max;
    }
}
```