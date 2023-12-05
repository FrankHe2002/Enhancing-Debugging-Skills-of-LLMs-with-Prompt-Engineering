Bug Type: Logical and Semantic

The bug in the given code is a logical error that causes incorrect computation of the maximum distance to the closest person. The logic of the code incorrectly handles the calculation of the maximum distance, leading to incorrect results.

In the original code:
- The logic to calculate the maximum distance between two occupied seats is incorrect. It fails to consider boundary cases where the closest occupied seat might occur at the very beginning or end of the seat row. The handling of these cases is incorrect, thus resulting in wrong output.

Fix:
```java
class Solution {
    public int maxDistToClosest(int[] seats) {
        int size = seats.length;
        int maxDistance = 0;
        int firstOccupied = -1;
        
        for (int i = 0; i < size; i++) {
            if (seats[i] == 1) {
                if (firstOccupied == -1) {
                    maxDistance = i;
                } else {
                    maxDistance = Math.max(maxDistance, (i - firstOccupied) / 2);
                }
                firstOccupied = i;
            }
            if (i == size - 1 && seats[i] == 0) {
                maxDistance = Math.max(maxDistance, size - 1 - firstOccupied);
            }
        }
        return maxDistance;
    }
}
```

The fixed code properly handles the boundary cases and correctly computes the maximum distance to the closest person in the seat row. Now, the code returns the correct maximum distance to the closest person.