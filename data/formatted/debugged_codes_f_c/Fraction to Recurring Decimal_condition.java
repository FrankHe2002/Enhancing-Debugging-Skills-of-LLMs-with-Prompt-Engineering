The bug in the provided code is in the while loop condition `while (remainder == 0)`. This condition is incorrect because it will cause an infinite loop if the remainder is non-zero. The fix is to change the condition to `while (remainder != 0)`, which ensures the loop continues until the remainder becomes zero.

Additionally, the code has indentation issues and missing semicolons at the end of some statements.

Fixed Code:
```java
import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder("");
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
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
        while (remainder != 0) {
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