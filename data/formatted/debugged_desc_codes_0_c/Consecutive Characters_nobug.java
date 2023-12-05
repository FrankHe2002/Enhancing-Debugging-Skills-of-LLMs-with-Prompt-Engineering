The bug in the code is the incorrect calculation of the maximum length of a non-empty substring that contains only one unique character.

To fix the bug, we need to make sure that we consider the maximum length of the current substring, regardless of whether it is greater or less than the previous maximum.

Here's the fixed code:

```java
// Runtime: 3 ms (Top 40.49%) | Memory: 42.4 MB (Top 68.55%)
class Solution {
    public int maxPower(String s) {
        int maxConsecutive = 1; 
        int counterConsecutive = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                counterConsecutive++;
            } else {
                counterConsecutive = 1;
            }
            maxConsecutive = Math.max(counterConsecutive, maxConsecutive);
        }

        return maxConsecutive;
    }
}
```

In the fixed code, we move the `Math.max` comparison outside of the if-else statement, so that we always consider the maximum length of the consecutive substring. This will ensure that we get the correct maximum length of a non-empty substring that contains only one unique character.