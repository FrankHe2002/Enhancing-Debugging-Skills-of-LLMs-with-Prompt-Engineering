The bug in the provided Java code appears to be in the logic of removing exactly one occurrence of digit from number to maximize the resulting string's value.

To identify and fix the bug, we can follow these steps:

Step 1: Review the code logic
The code iterates through the input number to find occurrences of the given digit. For each occurrence found, it creates a new string by removing the digit and adds it to a list. Then, the list of modified strings is sorted, and the maximum value string (last in the sorted list) is returned.

Step 2: Identify the bug
The bug in the code is that it doesn't consider the numerical value of the resulting strings after removing the digit. Simply sorting the modified strings does not guarantee that the resulting string will have the maximum numerical value.

Step 3: Apply the fix
To fix the bug, we should sort the modified strings based on their numerical values rather than the string values themselves. Then return the modified string with the maximum numerical value.

Here's the modified code with the bug fix:

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
        Collections.sort(digits, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return Integer.parseInt(b) - Integer.parseInt(a);
        });
        return digits.get(0);
    }
}
```

In the fixed code, we added a custom comparator to sort the modified strings based on their numerical values in descending order. This ensures that the resulting string with the maximum numerical value is returned.