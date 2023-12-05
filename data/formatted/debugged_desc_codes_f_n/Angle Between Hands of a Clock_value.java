```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.2 MB (Top 38.02%)
class Solution {
    public double angleClock(int hour, int minutes) {
        // Position of hour hand in a circle of 0 - 59
        double hrPos = 30 * (hour % 12) + 0.5 * minutes;

        double minPos = 6 * minutes;

        // Calculate the angle
        double angle = Math.abs(hrPos - minPos);

        // Take the smaller angle
        return Math.min(angle, 360 - angle);
    }
}
```