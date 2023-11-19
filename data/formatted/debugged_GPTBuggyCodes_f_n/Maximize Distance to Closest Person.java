```java
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
                if (start == -1) max = i;
                else max = Math.max((end - start) / 2, max);
            }
            if (i == size - 1 && end == size - 1 && seats[i] != 1) {
                end++;
            }
        }

        if (seats[size - 1] == 0 || start == -1) return Math.max(max, (size - 1 - end));
        return max;
    }
}
```