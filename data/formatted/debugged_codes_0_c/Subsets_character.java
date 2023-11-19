The bug in the code is a missing closing parenthesis in line 9. 

To identify the bug, we need to carefully examine the code and look for any syntax errors. In this case, scanning through the code, we can see a missing closing parenthesis after `new ArrayList(temp)`. 

To fix the bug, we simply need to add the missing closing parenthesis after `new ArrayList(temp)`. 

Here is the corrected code:

```java
import java.util.ArrayList;
import java.util.List;

class Solution {

    private static void solve(int[] nums, int i, List<Integer> temp, List<List<Integer>> subset) {

        if (i == nums.length) {
            subset.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        solve(nums, i + 1, temp, subset);

        temp.remove(temp.size() - 1);
        solve(nums, i + 1, temp, subset);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        if (nums.length == 0) return subset;

        int startInd = 0;

        solve(nums, startInd, temp, subset);

        return subset;
    }
}
```