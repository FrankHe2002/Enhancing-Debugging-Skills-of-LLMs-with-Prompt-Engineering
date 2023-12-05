```java
import java.util.Stack;

class Solution {
    public int mctFromLeafValues(int[] arr) {

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            sum += cleanUpStack(num, stack);
        }

        while (stack.size() > 1) {
            sum += stack.pop() * stack.peek();
        }

        return sum;
    }

    private int cleanUpStack(int target, Stack<Integer> stack) {
        int ans = 0;
        while (!stack.isEmpty() && stack.peek() <= target) {
            int cur = stack.pop();
            if (!stack.isEmpty()) {
                ans += cur * Math.min(stack.peek(), target);
            } else {
                ans += cur * target;
            }
        }
        stack.push(target);
        return ans;
    }
}
```