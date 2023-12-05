The identified bug in the code is in the second else block when the start index is greater than the destination index. The block lacks an increment operator in the second for loop, causing the loop not to iterate and compute the second distance.

Fix:
```java
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int firstDistance = 0;
        int secondDistance = 0;
        if (start < destination) {
            //check clockwise rotation
            for (int i = start; i < destination; i++)
                firstDistance += distance[i];
            //check clockwise rotation from destination to end
            for (int i = destination; i < distance.length; i++)
                secondDistance += distance[i];
            //continues checking till start (if needed)
            for (int i = 0; i < start; i++)
                secondDistance += distance[i];
        } else {
            for (int i = start; i < distance.length; i++)
                firstDistance += distance[i];
            for (int i = 0; i < destination; i++)
                firstDistance += distance[i];
            for (int i = start - 1; i >= destination; i--)
                secondDistance += distance[i];
        }
        return Math.min(firstDistance, secondDistance);
    }
}
```