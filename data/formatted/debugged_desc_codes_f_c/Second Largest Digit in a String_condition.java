The identified issue in the provided Java code for the `secondHighest` method is that the numeric check in the first loop has a logical AND operation issue and also has a condition for negative digits which is unnecessary.

Here is the revised and fixed code:

```java
class Solution {
    public int secondHighest(String s) {
        int[] arr = new int[10];

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                arr[s.charAt(i) - '0']++;
            }
        }

        boolean first = false;
        for (int i = 9; i >= 0; i--) {
            if (arr[i] != 0) {
                if (first) {
                    return i;
                } else {
                    first = true;
                }
            }
        }

        return -1;
    }
}
```

Explanation:
The `for` loop condition is updated to check if the character at the current index is a digit using the `Character.isDigit` method. The condition for negative digits is removed, and `first` is used to keep track of the second largest numerical digit. Additionally, minor improvements have been made to the structure and readability of the code.