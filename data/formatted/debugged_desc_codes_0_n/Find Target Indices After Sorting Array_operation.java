```java
// Runtime: 2 ms (Top 82.14%) | Memory: 43.8 MB (Top 60.21-)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0;
        int equal = 0;
        for (int num : nums) {
            if (num < target) {
                smaller++;
            } else if (num == target) {
                equal++;
            }
        }
        List<Integer> indices = new ArrayList<>(equal);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indices.add(i);
            }
        }
        return indices;
    }
}
```