The bug in the given Java code is that it doesn’t fulfill the requirements of the problem from the code description. It should count the number of indices where heights[i] != expected[i]. The current code is just comparing the sorted version of heights with the original array and returning the number of mismatches.

The fixed version of this code should create a separate sorted array from the expected heights and then compare to find differences.

Fixed code:

```java
import java.util.*;

class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int count = 0;
        
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;
    }
}
```