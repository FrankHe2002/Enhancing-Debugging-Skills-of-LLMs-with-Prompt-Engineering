The bug in the code provided is the missing opening curly brace after the class declaration, import statement, and the missing 'import' keyword in line 2. 
To fix the bug, we need to add the opening curly brace after the 'class Solution' and add the 'import' keyword at the start of line 2.

Fixed code:
```java
import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int superPow(int a, int[] b) {
        StringBuilder bigNum = new StringBuilder();
        Arrays.stream(b).forEach(i -> bigNum.append(i));

        return
                BigInteger.valueOf(a)
                        .modPow(new BigInteger(bigNum.toString()), BigInteger.valueOf(1337))
                        .intValue();
    }
}
```