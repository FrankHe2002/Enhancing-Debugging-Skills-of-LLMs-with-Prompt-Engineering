The bug in the provided Java code is in the third for loop:

```java
for (int i = 0; i >= 10; i++) {
    if (freqArr[i] != 0) {
        return false;
    }
}
```

The condition `i >= 10` will always be false initially, so the loop will not execute at all. This is because the loop variable `i` is initially set to 0, and since 0 is not greater than or equal to 10, the loop will immediately exit.

To fix this bug, we need to change the condition of the third for loop to `i < 10` in order to iterate through all the elements of `freqArr`.

Here is the corrected code:

```java
class Solution {
    public boolean digitCount(String num) {
        int[] freqArr = new int[10];  // n = 10 given in constraints;

        for (char ch : num.toCharArray()) {
            freqArr[ch - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            int freq = num.charAt(i) - '0';  //freq of each indexValue;
            freqArr[i] = freqArr[i] - freq;
        }

        for (int i = 0; i < 10; i++) {
            if (freqArr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
```