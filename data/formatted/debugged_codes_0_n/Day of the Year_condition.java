```java
class Solution {
    public int dayOfYear(String date) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = (date.charAt(0) - '0') * 1000 + (date.charAt(1) - '0') * 100 + (date.charAt(2) - '0') * 10 + date.charAt(3) - '0';
        if (year % 4 == 0 && year != 1900) {
            months[1]++;
        }
        int ans = 0;
        for (int i = 0; i <= ((date.charAt(5) - '0') * 10) + date.charAt(6) - '1'; i++) {
            ans += months[i];
        }
        ans += (date.charAt(8) - '0') * 10 + date.charAt(9) - '0';
        return ans;
    }
}
```
