```java
class Solution {
    public int maxDistToClosest(int[] seats) {
        int size = seats.length;
        int max = 0;
        int start = -1;
        for (int i = 0; i < size; i++) {
            if (seats[i] == 1) {
                if (start == -1) {
                    max = i;
                } else {
                    max = Math.max((i - start) / 2, max);
                }
                start = i;
            }
        }

        max = Math.max(size - 1 - start, max);

        return max;
    }
}
```