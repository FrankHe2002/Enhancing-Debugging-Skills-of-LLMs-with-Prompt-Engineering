The bug in the provided Java code is in the for loop condition of the `isStrictlyPalindromic` method. 

Currently, the for loop runs from `2` to `n - 1`. However, it should run from `2` to `n` in order to include `n` as one of the bases for converting `n` to a string. 

To fix this bug, we need to modify the for loop condition to `i <= n`. 

Here's the fixed code:

```java
class Solution {
    public boolean isStrictlyPalindromic(int n) {
        boolean flag = true;
        for (int i = 2; i <= n; i++) {
            if (! check(Integer.toString(n, i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean check(String n) {
        int left = 0;
        int right = n.length() - 1;
        while (left < right) {
            if (n.charAt(left) != n.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
```

This fix ensures that the for loop condition allows `n` to be included as a base for converting `n` to a string and checks if the string is a palindrome in all cases.