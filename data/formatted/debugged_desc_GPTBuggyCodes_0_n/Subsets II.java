```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subset(new ArrayList<Integer>(), nums);
    }

    public List<List<Integer>> subset(ArrayList<Integer> prefix, int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>(prefix));
            return result;
        }
        ArrayList<Integer> withCurrent = new ArrayList<>(prefix);
        withCurrent.add(nums[0]);
        List<List<Integer>> left = subset(withCurrent, Arrays.copyOfRange(nums, 1, nums.length));

        List<List<Integer>> right = new ArrayList<>();
        if (prefix.size() > 0 && prefix.get(prefix.size() - 1) != nums[0]) {
            right = subset(prefix, Arrays.copyOfRange(nums, 1, nums.length));
        }
        left.addAll(right);
        return left;
    }
}
```