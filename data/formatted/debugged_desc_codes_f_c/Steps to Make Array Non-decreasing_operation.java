The given code has the following issues:
1. Invalid division in `st.push(new Pair(nums[n / 1], 0));`
2. Typo in the parameter of `push` and `new Pair` methods causing a compilation error.

We can address these problems and improve the solution as follows:

```java
import javafx.util.Pair;
import java.util.Stack;

class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int ans = 0;

        Stack<Pair<Integer, Integer>> st = new Stack<>();

        st.push(new Pair<>(nums[n - 1], 0));

        for (int i = n - 2; i >= 0; i--) {
            int count = 0;
            while (!st.isEmpty() && nums[i] > st.peek().getKey()) {
                count = Math.max(count + 1, st.peek().getValue());
                st.pop();
            }
            ans = Math.max(ans, count);
            st.push(new Pair<>(nums[i], count));
        }
        return ans;
    }
}
```
This revised Java code provides the correct implementation for total number of steps to convert the array into a non-decreasing array, addressing the identified bugs.