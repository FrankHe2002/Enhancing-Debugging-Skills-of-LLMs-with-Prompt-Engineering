The bug in the provided code is in the calculation of the sum values. 

The code loops through each character in the firstWord, secondWord, and targetWord strings and calculates the sum by adding the ASCII value of each character minus the ASCII value of 'a', and then multiplying the sum by 10. 

However, the multiplication by 10 should be done after adding each character's value, not inside the loop. 

To fix this bug, we need to move the multiplication by 10 outside the loop.

Here is the corrected code:

```java
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sumfirst = 0, sumsecond = 0, sumtarget = 0;
        for (char c : firstWord.toCharArray()) {
            sumfirst = sumfirst * 10 + (c - 'a');
        }
        for (char c : secondWord.toCharArray()) {
            sumsecond = sumsecond * 10 + (c - 'a');
        }
        for (char c : targetWord.toCharArray()) {
            sumtarget = sumtarget * 10 + (c - 'a');
        }

        return (sumfirst + sumsecond) == sumtarget;
    }
}
```
By moving the multiplication by 10 outside the loop, we ensure that the sum is calculated correctly for each character.