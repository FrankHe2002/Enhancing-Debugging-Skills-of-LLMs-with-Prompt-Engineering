The bug in the provided code can be identified by observing the method invocation on line 7. The parameter passed to the constructor of the BigInteger class is "num-1" instead of "num1".

To fix the bug, we need to change "num-1" to "num1" so that the correct input string is passed to the BigInteger constructor.

Here is the corrected code:

```java
import java.math.BigInteger;

class Solution {
    public String addStrings(String num1, String num2) {
        return new BigInteger(num1).add(new BigInteger(num2)).toString();
    }
}
```