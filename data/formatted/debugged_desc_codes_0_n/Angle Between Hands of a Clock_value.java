```java
class Solution {
    public double angleClock(int hour, int minutes) {
        double hrPos = 30 * (hour % 12) + (0.5 * minutes);
        double minPos = 6 * minutes;

        double angle = Math.abs(minPos - hrPos);
        
        return Math.min(angle, 360 - angle);
    }
}
```