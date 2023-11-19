```java
// Runtime: 85 ms (Top 20.04%) | Memory: 49.5 MB (Top 50.90%)
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; // Fixed: Initialize count variable to 0 instead of Integer.MIN_VALUE
        for (int i = lowLimit; i <= highLimit; i++) { // Fixed: Change < to <= to include highLimit
            int value = 0;
            int temp = i;
            while (temp != 0) {
                value += temp % 10;
                temp /= 10;
            }
            map.put(value, map.getOrDefault(value, 0) + 1);
            count = Math.max(map.get(value), count); // Fixed: Use Math.max() to avoid redundant assignment
        }
        return count;
    }
}
```