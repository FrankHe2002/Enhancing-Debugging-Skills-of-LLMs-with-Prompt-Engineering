class Solution {
    public double angleClock(int hour, int minutes) {
        double hrPos = 5 * (hour % 12);
        hrPos += (5 * minutes / 60.0);

        double units = Math.abs(minutes - hrPos);
        return Math.min(units, 60 - units) * 6;
    }
}