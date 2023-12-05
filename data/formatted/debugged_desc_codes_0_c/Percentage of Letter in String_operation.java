The bug in the given code is in the calculation of the percentage. 

1. The calculation of the percentage is incorrect. It should be (100 * count) / n to get the percentage, not (100 * count) % n.
2. The return type of the method should be 'int' as it is supposed to return the percentage as an integer value rounded down to the nearest whole percent.

Here's the corrected code:

```java
class Solution {
    public int percentageLetter(String str, char letter) {
        int count = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == letter) {
                count++;
            }
        }
        int per = (100 * count) / n; // Change from % to /
        return per;
    }
}
```