```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        int max = 0;
        for (int n : nums) {
            int value = 0;
            while (n > 0) {
                if (n % 2 == 1) {
                    value++;
                }
                n /= 2;
            }
            max = Math.max(max, value);
        }
        return max;
    }
}
```