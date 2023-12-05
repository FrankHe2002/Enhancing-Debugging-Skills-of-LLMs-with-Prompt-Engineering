```java
class Solution {
    public double angleClock(int hour, int minutes) {
        // Position of hour hand in a circle of 0 - 59
        double hrPos = 5 * (hour % 12);

        // Adjust hour hand position according to minute hand
        hrPos += (1.0 / 12) * minutes;

        double units = Math.abs(hrPos - minutes);

        // Calculate the minimum angle
        return Math.min(units, 60 - units) * 6;
    }
}
```