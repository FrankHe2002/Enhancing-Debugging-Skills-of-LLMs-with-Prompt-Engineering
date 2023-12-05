```java
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;
        int c1 = capacityA, c2 = capacityB;
        for (int start = 0, end = plants.length - 1; start <= end; start++, end--) {
            if (start == end) {
                if (c1 + c2 < plants[start]) {
                    c1 = capacityA - plants[start];
                    c2 = capacityB - plants[start];
                    count++;
                }
                break;
            } else {
                if (c1 < plants[start]) {
                    c1 = capacityA;
                    c1 -= plants[start];
                    count++;
                } else {
                    c1 -= plants[start];
                }
                if (c2 < plants[end]) {
                    c2 = capacityB;
                    c2 -= plants[end];
                    count++;
                } else {
                    c2 -= plants[end];
                }
            }
        }
        return count;
    }
}
```