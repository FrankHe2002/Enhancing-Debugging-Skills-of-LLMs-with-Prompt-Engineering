The bug in the provided code is that it does not handle cases where there are multiple occurrences of the specified digit in the number. The code only removes the first occurrence of the digit and adds the resulting string to the list of digits.

To fix this bug, we need to modify the code to remove all occurrences of the digit from the number and add all resulting strings to the list of digits.

Fixed Code:
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String removeDigit(String number, char digit) {
        List<String> digits = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String stringWithoutDigit = number.substring(0, i) + number.substring(i + 1);
                digits.add(stringWithoutDigit);
            }
        }
        Collections.sort(digits);
        return digits.isEmpty() ? number : digits.get(digits.size() - 1);
    }
}
```

In the fixed code, we check if the list of digits is empty before returning the result. If the list is empty, it means that the specified digit was not found in the number, so we simply return the original number.