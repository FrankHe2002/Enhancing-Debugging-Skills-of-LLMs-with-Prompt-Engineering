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
        total += (year - 1971) * 365;
        for (int i = 1972; i < year; i += 4) {
            if (isLeapYear(i)) total++;
        }
        int feb = isLeapYear(year) ? 29 : 28;
        switch (month) {
            case 12:
                total += 30;
            case 11:
                total += 31;
            case 10:
                total += 30;
            case 9:
                total += 31;
            case 8:
                total += 31;
            case 7:
                total += 30;
            case 6:
                total += 31;
            case 5:
                total += 30;
            case 4:
                total += 31;
            case 3:
                total += feb;
            case 2:
                total += 31;
            case 1:
                total += day;
        }
        return total;
    }

    private boolean isLeapYear(int i) {
        return (i % 4 == 0) && ((i % 100 == 0 && i % 400 == 0) || i % 100 != 0);
    }
}
