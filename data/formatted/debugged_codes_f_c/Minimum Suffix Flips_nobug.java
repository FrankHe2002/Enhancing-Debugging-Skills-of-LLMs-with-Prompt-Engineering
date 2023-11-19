Bug type: Logical error

Reasoning: Upon analyzing the code, it appears that the goal is to count the number of flips needed to transform the string `target` into all zeros. The code uses a boolean variable `lastBit` to keep track of the current state of the bits. If the current bit in `target` is different from `lastBit`, a flip is required and the `flips` counter is incremented. However, the logic for checking the flips is flawed.

To fix the bug, the code should only count a flip when the current bit in `target` is different from the desired state (i.e., zero). Currently, the code counts a flip whenever the current bit is different from `lastBit`. This means that if the string starts with zeros, the code will count all the transitions from zero to one, and if the string starts with ones, the code will count all the transitions from one to zero. 

To correct this, we need to check if the current bit is different from the desired state (zero), not the previous bit (`lastBit`). If it's different, a flip is needed and the `flips` counter is incremented.

Fixed Code:
```java
// Runtime: 0 ms (Top 100.00%) | Memory: 38.6 MB (Top 59.01%)

class Solution {
    public int minFlips(String target) {

        boolean lastBit = false;

        int flips = 0;
        for (int i = 0; i < target.length(); i++) {

            if (target.charAt(i) == '1' && !lastBit) {
                flips++;
                lastBit = true;
            } else if (target.charAt(i) == '0' && lastBit) {
                flips++;
                lastBit = false;
            }

        }

        return flips;

    }
}
```