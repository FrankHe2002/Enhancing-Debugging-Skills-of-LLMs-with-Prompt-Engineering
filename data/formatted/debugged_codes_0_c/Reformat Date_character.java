The bug in the provided code is a syntax error in the last line. The closing parenthesis of the `toString()` method is missing, causing a compilation error.

To fix this, we need to add the closing parenthesis after `toString()` in the last line.

Here is the corrected code:

```java
import java.util.Arrays;

class Solution {
    public String reformatDate(String date) {
        int len = date.length();

        String[] monthArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        String year = date.substring(len - 4);
        int month = Arrays.asList(monthArray).indexOf(date.substring(len - 8, len - 5)) + 1;
        String day = date.substring(0, len - 11);

        StringBuffer sb = new StringBuffer();

        sb.append(year + "-");

        if (month < 10)
            sb.append("0" + month + "-");
        else
            sb.append(month + "-");

        if (day.length() == 1)
            sb.append("0" + day);
        else
            sb.append(day);

        return sb.toString();
    }
}
```

Now the code will compile and run without any syntax errors.