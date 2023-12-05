Solution:
```java
import java.util.TreeMap;
import java.util.Map;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> destinationToPassengers = new TreeMap<>();
        for (int[] trip : trips) {
            int currPassengersAtPickup = destinationToPassengers.getOrDefault(trip[1], 0);
            int currPassengersAtDrop = destinationToPassengers.getOrDefault(trip[2], 0);
            destinationToPassengers.put(trip[1], currPassengersAtPickup + trip[0]);
            destinationToPassengers.put(trip[2], currPassengersAtDrop - trip[0]);
        }

        int currPassengers = 0;
        for (int key : destinationToPassengers.keySet()) {
            currPassengers += destinationToPassengers.getOrDefault(key, 0);
            if (currPassengers > capacity) {
                return false;
            }
        }
        return true;
    }
}
```