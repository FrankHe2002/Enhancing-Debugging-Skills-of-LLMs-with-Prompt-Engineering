```java
class Solution {
    public long minimumPerimeter(long neededApples) {
        long n = -1;
        long count = 0;
        while (count < neededApples) {
            n++;
            count += (12 * n * (n + 1)); // Adjusted the formula for counting apples
        }
        return n * 8;
    }
}
```