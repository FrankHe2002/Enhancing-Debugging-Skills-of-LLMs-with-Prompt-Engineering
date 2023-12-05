The bug in the provided code is the incorrect index assignment to the `start` variable. The `start` and `end` indices need to be set to the previous filled seat's index and the current filled seat's index, respectively. As a result, the condition to update the `max` value and the calculation of the middle index between two filled seats also need to be modified.

The fixed code should update the `start` variable to `end` and set `end` to the current value of `i`. The condition for the special case when there is only one '1' in the array should also be adjusted. Additionally, the special case handling before returning the `max` value needs to be corrected to ensure the correct handling of the last empty seat and single '1' in the array.

Fixed code:

```java
// Runtime: 12 ms (Top 6.92%) | Memory: 49.9 MB (Top 21.03%)

class Solution {
    public int maxDistToClosest(int[] seats) {
        int size = seats.length;
        int max = 0;
        int start = - 1;
        int end = - 1;

        for (int i = 0; i < size; i++) {
            if (seats[i] != 0) {
                start = end; // update start to end when we have a filled seat.
                end = i; // update end with i pointer when we have a filled seat.
                if (start == - 1) max = end; // for a special case when there is only '1' in the array
                else max = Math.max((end - start) / 2, max); // updating max.
            }
        }

        // Handling special cases before returning max.
        // 1) last element is 0 as we won't be updating max for that in the above loop.
        // 2) when there is only a single '1' in the array, we need to make sure whether the right half is bigger than the left half.

        if (seats[size - 1] == 0 || start == -1) return Math.max(max, size - 1 - end);
        return max;
    }
}
```