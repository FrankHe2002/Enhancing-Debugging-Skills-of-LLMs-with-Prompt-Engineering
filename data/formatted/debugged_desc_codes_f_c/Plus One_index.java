The bug in the code is related to accessing and updating array elements. Also, the condition inside the while loop is incorrect. The following is the fixed code for the PlusOne function:

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        //last digit not a 9, just add 1 to it
        if (digits[len - 1] != 9) {
            digits[len - 1] = digits[len - 1] + 1;
            return digits;
        }
        else {
            int i = len - 1;
            while (i >= 0 && digits[i] == 9) { // correct the index to check 9
                digits[i] = 0;
                i--;
            }
            if (i == -1) {
                int[] ret = new int[len + 1];
                ret[0] = 1;
                return ret;
            }
            digits[i] = digits[i] + 1;
        }
        return digits;
    }
}
```