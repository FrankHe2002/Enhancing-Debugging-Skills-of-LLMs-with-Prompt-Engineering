The bug in the given code is the incorrect calculation of the 'count' variable inside the for loop. The condition `count = count + i + (i + 1);` should be replaced with `count += 2 * (i + 1);` to count the additional steps required for reaching the river and subsequently watering the plants from that position.

Fix:
```java
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int count = 0, c = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (c >= plants[i]) {
                c -= plants[i];
                if (i == plants.length - 1) {
                    return count;
                }
            } else {
                c = capacity;
                count += 2 * (i + 1);
                c -= plants[i];
            }
        }
        return count;
    }
}
```