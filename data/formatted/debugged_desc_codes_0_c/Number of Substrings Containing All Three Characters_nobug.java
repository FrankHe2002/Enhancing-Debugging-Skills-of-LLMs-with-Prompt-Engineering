The bug is with the logic of counting the substrings. The way the `doCount` method is called inside the `while` loop is incorrect.

Here's the fixed code:

```java
class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0, b = 0, c = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    ++a;
                    break;
                case 'b':
                    ++b;
                    break;
                case 'c':
                    ++c;
                    break;
            }
            if (a > 0 && b > 0 && c > 0) {
                count += i + 1; // Add all substrings from the beginning up to the current index
                while (a > 0 && b > 0 && c > 0) {
                    switch (s.charAt(i - a - b - c + 1)) {
                        case 'a':
                            --a;
                            break;
                        case 'b':
                            --b;
                            break;
                        case 'c':
                            --c;
                            break;
                    }
                    count += i - a - b - c + 1; // Add all substrings from the new beginning to the current index
                }
            }
        }
        return count;
    }
}
```