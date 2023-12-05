```java
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = 0;
        for (int i = 1971; i < year; i++) {
            if (i % 4 == 0) {
                total += 366;
            } else {
                total += 365;
            }
        }
        if (year % 4 == 0 && year != 2100) {
            months[1]++;
        }
        for (int i = 0; i < month - 1; i++) {
            total += months[i];
        }
        total += day - 1;
        return week[total % 7];
    }
}
```