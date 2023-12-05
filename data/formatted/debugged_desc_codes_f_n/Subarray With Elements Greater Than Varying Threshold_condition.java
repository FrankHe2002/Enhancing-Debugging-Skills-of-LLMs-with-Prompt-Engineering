```java
import java.util.*; 
class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int pos = -1;
        for (pos = 0; pos < nums.length; pos++) {
            if (nums[pos] > threshold) {
                break;
            }
        }
        if (pos == nums.length) {
            return -1;
        }
        for (int k = 1; k < nums.length; k++) {
            for (int i = 0; i < nums.length - k + 1; i++) {
                if (threshold / k < Arrays.stream(Arrays.copyOfRange(nums, i, k + i)).min().getAsInt()) {
                    return k;
                }
            }
        }
        return -1;
    }
}
```