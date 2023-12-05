The provided Java code has the following issues:
1. The condition `if (chars[left] == chars[-1])` is incorrect. It should be `if (chars[left] == chars[right])`.
2. The loop condition `for (int left = 0, right = chars.length - 1; left < right; )` does not modify the iterations directly. It should have `left++` and `right--` inside the loop to avoid an infinite loop.

Here's the revised code with the fixes:

```java
class Solution {
    public int minimumLength(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        for (int left = 0, right = chars.length - 1; left < right; left++, right--) {
            if (chars[left] == chars[right]) {
                char c = chars[left];
                while (left < right && chars[left] == c) {
                    left++;
                    length--;

                }

                while (right >= left && chars[right] == c) {
                    right--;
                    length--;

                }
            } else {
                break;
            }
        }
        return length;
    }
}
```

The debugging process involved carefully reviewing the code and identifying logical errors. By correcting the condition inside the loop and adding the increment/decrement operations for `left` and `right`, the issues have been fixed.