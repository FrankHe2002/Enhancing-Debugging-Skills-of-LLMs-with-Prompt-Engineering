The bug in the provided code is related to the calculation of the total number of days. It's assuming leap years incorrectly and missing the proper calculation of leap year days.

Here's the step-by-step process to identify and fix the bug:
1. The code incorrectly calculates the total number of days by assuming a year has 366 days if it's a leap year and 365 days otherwise. However, this approach doesn't account for leap years accurately. A leap year occurs every 4 years, with the exception of years that are divisible by 100 but not by 400. This logic is not correctly implemented in the code.
2. The method of modifying the `months` array for a leap year is incorrect. It adds an extra day to the month of February if the year is a leap year, but it doesn't consider specific leap year conditions.
3. The code also multiplies the total by the day, which is incorrect. The correct calculation should consider the current day in relation to a specific date.

To fix the bug:
1. We need to modify how the leap year is checked and handled. We can create a separate function to determine if a year is a leap year, and then consider this information when calculating the total days.

Here's the fixed code:

```java
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        int total = 0;
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                total += 366;
            } else {
                total += 365;
            }
        }
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // February has 29 days in a leap year
        }
        
        for (int m = 1; m < month; m++) {
            total += daysInMonth[m - 1];
        }
        
        total += day - 1; // subtract 1 to get the zero-based index
        
        return week[total % 7];
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
```