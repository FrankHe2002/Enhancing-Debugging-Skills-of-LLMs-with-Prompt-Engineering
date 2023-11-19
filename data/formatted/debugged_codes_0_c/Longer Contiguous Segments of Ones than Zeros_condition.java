The bug in the provided Java code is in the second while loop that counts the number of zeros (0s) in the string. 

The condition of the second while loop is `i >= s.length() && s.charAt(i) == '0'`. This condition is always false because `i` is initialized with 0, and thus, `i` is always less than `s.length()`. As a result, the loop never executes, and `length0` remains 0.

To fix this bug, we need to change the condition of the second while loop to `i < s.length() && s.charAt(i) == '0'` so that it iterates over the string and counts the zeros correctly.

Here is the modified code with the bug fix:

```java
class Solution {
    public boolean checkZeroOnes(String s) {
        int length1 = 0;
        int length0 = 0;
        int i = 0;
        while (i < s.length()) {
            int temp = 0;
            while (i < s.length() && s.charAt(i) == '1') { // counting 1s
                temp++;
                i++;
            }
            length1 = Math.max(temp, length1);
            temp = 0;
            while (i < s.length() && s.charAt(i) == '0') { // counting 0s
                temp++;
                i++;
            }
            length0 = Math.max(temp, length0);
        }
        return length1 > length0;
    }
}
```
By changing the condition in the second while loop, we ensure that the loop iterates over the string and counts the zeros correctly.