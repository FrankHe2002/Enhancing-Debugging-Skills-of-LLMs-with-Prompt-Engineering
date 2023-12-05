The bug type in the provided Java code is the logical error due to the incorrect implementation of the `fractionToDecimal` function. The issue lies in the while loop condition `while (remainder == 0)`, which should instead be `while (remainder != 0)` to properly handle the division and detect repeating fractions.

Here's the fixed code with the identified bug addressed:

```java
import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder("");
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sb.append("-");
        }

        long divisor = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);
        long remainder = divisor % dividend;
        sb.append(divisor / dividend);

        if (remainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (remainder != 0) {  // Fix the while loop condition
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / dividend);
            remainder %= dividend;
        }
        return sb.toString();
    }
}
```
The above fix addresses the logical error by changing the while loop condition `while (remainder == 0)` to `while (remainder != 0)` to properly handle the division process and identify repeating fractions.