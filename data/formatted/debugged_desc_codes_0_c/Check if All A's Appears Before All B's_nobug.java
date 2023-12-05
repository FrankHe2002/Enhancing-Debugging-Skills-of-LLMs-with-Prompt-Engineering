The given code has a bug. The code is currently checking if every 'a' appears before every 'b' in the string. However, the code should check if every 'a' appears before any 'b' in the string. This means that if there is at least one 'b' that appears before an 'a', the function should return false.

To fix this bug, we need to change the inner loop to iterate through the entire string and return false as soon as we find a 'b' before an 'a'.

Here's the fixed code:

```java
class Solution {
    public boolean checkString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == 'a') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
```

With this change, the function will now correctly return false if it encounters a 'b' before an 'a', and true otherwise.