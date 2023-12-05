Fix:
```java
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int total = 0;
        for(int i = 1971; i < year; i++){
            if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0){
                total += 366;
            } else {
                total += 365;
            }
        }
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            months[1] = 29;
        }
        for(int i = 0; i < month - 1; i++){
            total += months[i];
        }
        total += day;
        return week[(total - 1) % 7];
    }
}
```