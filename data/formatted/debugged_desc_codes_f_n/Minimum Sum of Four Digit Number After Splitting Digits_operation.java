Fix:
```java
import java.util.*;

class Solution {
    public int minimumSum(int num) {
        int[] dig = new int[4]; // For each digit
        int cur = 0;
        while (num > 0) // Getting each digit
        {
            dig[cur++] = num % 10;
            num /= 10;
        }
        Arrays.sort(dig); // Ascending order
        int num1 = dig[0] * 10 + dig[1]; // 1st and 2nd digit
        int num2 = dig[2] * 10 + dig[3]; // 3rd and 4th digit
        return num1 + num2;
    }
}
```