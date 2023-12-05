Fix:
```java
// Runtime: 2 ms (Top 91.15/) | Memory: 43.1 MB (Top 10.07%)
import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 2)
            return false;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) {
                return false;
            }
        }
        return true;
    }
}
```