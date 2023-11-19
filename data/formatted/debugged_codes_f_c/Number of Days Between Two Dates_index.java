Bug type: Syntax error, missing "]" in array indexing.

The bug is present in the line `return (int) Math.abs(daysFrom1971(Integer.parseInt(d1[years]), Integer.parseInt(d1[1]), Integer.parseInt(d1[2])) - daysFrom1971(Integer.parseInt(d2[0]), Integer.parseInt(d2[1]), Integer.parseInt(d2[2])));`.

In this line, `d1[years]` should be `d1[0]` to access the year component of `date1`. Similarly, `d2[0]` should be used instead of `d2[years]` to access the year component of `date2`.

To fix the bug, the array indexing should be corrected by replacing `years` with `0`. 

Fixed code:

```java
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        return (int) Math.abs(
                daysFrom1971(Integer.parseInt(d1[0]), Integer.parseInt(d1[1]), Integer.parseInt(d1[2]))
                        - daysFrom1971(Integer.parseInt(d2[0]), Integer.parseInt(d2[1]), Integer.parseInt(d2[2])));
    }

    private int daysFrom1971(int year, int month, int day) {
        int total = 0;
        // count years first
        total += (year - 1971) * 365;
        for (int i = 1972; i < year; i += 4) {
            if (isLeapYear(i)) total++;
        }
        int feb = isLeapYear(year) ? 29 : 28;
        // sum months and days
        switch (month) {
            case 12:
                total += 30; // 11
            case 11:
                total += 31; // 10
            case 10:
                total += 30; // 9
            case 9:
                total += 31; // 8
            case 8:
                total += 31; // 7
            case 7:
                total += 30; // 6
            case 6:
                total += 31; // 5
            case 5:
                total += 30; // 4
            case 4:
                total += 31; // 3
            case 