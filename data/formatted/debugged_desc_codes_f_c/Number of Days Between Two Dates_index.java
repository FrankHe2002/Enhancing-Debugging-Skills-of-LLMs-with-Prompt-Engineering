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
        for (int i = 1972; i < year; i++) {
            if (isLeapYear(i)) total++;
        }
        int feb = isLeapYear(year) ? 29 : 28;
        
        // sum months except for the current one
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 12:
                case 10:
                case 8:
                case 7:
                case 5:
                case 3:
                case 1:
                    total += 31;
                    break;
                case 11:
                case 9:
                case 6:
                case 4:
                    total += 30;
                    break;
                case 2:
                    total += feb;
                    break;
            }
        }
        // add the day
        total += day;
        return total;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
}
```