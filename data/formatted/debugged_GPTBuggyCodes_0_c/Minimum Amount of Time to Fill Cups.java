The bug in the provided Java code is that it does not handle the condition where x == 0, y == 0, and z == 0. In this case, the code incorrectly returns the value of z, instead of properly calculating the sum of x, y, and z divided by 2 plus the remainder.

To fix this bug, we need to remove the else block that erroneously returns the value of z when x == 0 and y == 0. This will allow the code to correctly calculate the sum of x, y, and z. 

Here's the fixed code:

```java
import java.util.Arrays;

class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int x = amount[0];
        int y = amount[1];
        int z = amount[2];
        int sum = x + y + z;
        if (x + y > z) {
            return sum / 2 + sum % 2;
        }
        return sum / 2;
    }
}
```