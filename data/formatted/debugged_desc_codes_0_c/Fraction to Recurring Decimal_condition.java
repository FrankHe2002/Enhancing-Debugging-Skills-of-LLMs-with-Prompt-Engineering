Bug Type:
The bug type in the provided code is a logical error.

Reasoning:
1. The code uses a while loop to calculate the decimal part of the fraction by finding remainders. However, the condition `while (remainder == 0)` will cause an infinite loop because the loop should continue as long as the remainder is not zero.

2. Additionally, the condition for checking if the remainder is repeating (`if (map.containsKey(remainder))`) should be `if (map.containsKey(remainder))` instead of `while (remainder == 0)`.

3. The code also does not handle negative long values correctly in all scenarios.

4. Furthermore, the code does not return the correct result when a repeating fraction is encountered.

To fix the bug, we should:
- Change the condition `while (remainder == 0)` to `while (remainder != 0)`.
- Replace the `while` loop condition with an `if` condition for checking if the remainder is repeating.
- Handle the negative values for the numerator and denominator correctly.

The corrected code is as follows:

```java
import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        sb.append(dividend / divisor);
        long remainder = dividend % divisor;

        if (remainder == 0) {
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / divisor);
            remainder %= divisor;
        }

        return sb.toString();
    }
}
```