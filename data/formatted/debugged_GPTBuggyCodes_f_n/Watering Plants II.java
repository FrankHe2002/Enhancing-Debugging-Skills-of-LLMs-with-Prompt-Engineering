```java
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;
        int c1 = capacityA, c2 = capacityB;
        for (int start = 0, end = plants.length - 1; start <= end; start++, end--) {
            if (start == end) {
                if (c1 < plants[start] && c2 < plants[start])
                    count++;
                break;
            }
            if (c1 < plants[start]) {
                count++;
                c1 = capacityA;
            }
            c1 -= plants[start];
            if (c2 < plants[end]) {
                count++;
                c2 = capacityB;
            }
            c2 -= plants[end];
        }
        return count;
    }
}
```