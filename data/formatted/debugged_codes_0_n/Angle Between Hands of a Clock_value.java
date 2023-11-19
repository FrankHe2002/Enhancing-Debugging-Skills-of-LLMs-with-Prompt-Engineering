```java
class Solution {
    public double angleClock(int hour, int minutes) {
        double hrPos = 30 * (hour % 12) + (0.5 * minutes);
        double units = Math.abs(minutes - hrPos);
        return Math.min(units, 360 - units);
    }
}
```