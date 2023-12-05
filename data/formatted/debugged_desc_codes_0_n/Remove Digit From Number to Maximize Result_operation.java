```java
// Runtime: 4 ms (Top 37.58-) | Memory: 43 MB (Top 24.40%)
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String removeDigit(String number, char digit) {
        List<String> digits = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String stringWithoutDigit = number.substring(0, i) + number.substring(i + 1);
                digits.add(stringWithoutDigit);
            }
        }
        Collections.sort(digits, Collections.reverseOrder());
        return digits.get(0);
    }
}
```