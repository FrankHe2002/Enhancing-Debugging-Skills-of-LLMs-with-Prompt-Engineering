Fix:
```java
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int count = 0, c = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (c >= plants[i]) {
                c -= plants[i];
            } else {
                c = capacity;
                count++;
                c -= plants[i];
            }
            count++;
        }
        return count;
    }
}
```