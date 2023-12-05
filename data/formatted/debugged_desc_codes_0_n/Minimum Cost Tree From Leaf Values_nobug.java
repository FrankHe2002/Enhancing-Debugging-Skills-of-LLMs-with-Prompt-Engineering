```java
import java.util.Stack;

class Solution {
    public int mctFromLeafValues(int[] arr) {

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            sum += cleanUpStack(num, stack);
        }

        return sum;
    }

    private int cleanUpStack(int target, Stack<Integer> stack) {
        int last = 1;
        int sum = 0;
        while (! stack.isEmpty() && stack.peek() <= target) {
            int cur = stack.pop();
            sum += Math.max(last, cur);
            last = cur;
        }
        if (!stack.isEmpty()) {
            sum += target * Math.max(last, stack.peek());
        }
        stack.push(target);
        return sum;
    }
}
```