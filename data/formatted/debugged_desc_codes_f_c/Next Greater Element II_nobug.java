#### Final Fixed Code:

```java
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i % n]) {
                s.pop();
            }
            result[i % n] = s.isEmpty() ? -1 : nums[s.peek()];
            s.push(i % n);
        }
        return result;
    }
}
```