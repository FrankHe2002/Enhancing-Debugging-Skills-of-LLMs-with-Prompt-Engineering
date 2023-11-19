The bug in this code is that it does not correctly calculate whether a given year is a leap year or not. 

To fix this issue, we need to make the following changes:
1. Remove the line `year--` on line 4.
2. Remove the line `year++` on line 11.
3. Modify the condition `year % 4 == 0 && year != 2100` on line 12 to `year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)`.
4. Update the line `months[1]++` on line 13 to `months[1] = 29` to correctly set the number of days in February for a leap year.

Here is the corrected code:

```java
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        int total = (year / 4) * 366 + (year - year / 4) * 365;
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            months[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            total += months[i];
        }
        total *= day;

        return week[(total - 1) % 7];
    }
}
```

By making these changes, we correctly handle leap years and calculate the total number of days before the given date. Finally, we return the corresponding day of the week based on the total number of days.