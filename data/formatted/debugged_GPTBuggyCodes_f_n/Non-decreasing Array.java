Fixed Code:
```java
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int modified = 0, prev = nums[0], index = 0;
        for (; index < nums.length; ++ index) {
            if (nums[index] < prev) {
                if (++ modified > 1) return false;
                if (index - 1 >= 0 && nums[index - 1] > nums[index]) break;
            }
            prev = nums[index];
        }
        return true;
    }
}
```