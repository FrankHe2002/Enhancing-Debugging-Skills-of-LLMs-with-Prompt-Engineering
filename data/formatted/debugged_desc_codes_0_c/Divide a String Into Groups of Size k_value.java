The bug in the code is that if the `rem` is equal to -1, the for loop will still run, which will result in an ArrayIndexOutOfBoundsException. To fix this, we need to add an if condition to check if `rem` is not equal to -1 before entering the loop.

Here's the corrected code:

```java
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int rem = -1;
        if (s.length() % k != 0) {
            rem = k - s.length() % k;
        }
        
        if (rem != -1) {
            for (int i = 0; i < rem; i++) {
                s = s + fill;
            }
        }

        String[] strs = new String[s.length() / k];
        int index = 0;
        for (int i = 0; i < s.length(); i += k) {
            strs[index] = s.substring(i, i + k);
            index++;
        }
        return strs;
    }
}
```