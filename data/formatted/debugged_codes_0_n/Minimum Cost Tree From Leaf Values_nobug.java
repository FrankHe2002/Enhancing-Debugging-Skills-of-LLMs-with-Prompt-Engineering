```java
import java.util.Stack;
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            sum += cleanUpStack(num, stack);
        }
        sum += cleanUpStack(Integer.MAX_VALUE, stack); // Changed target value to Integer.MAX_VALUE
        return sum;
    }

    private int cleanUpStack(int target, Stack<Integer> stack) {
        int last = 1; // Changed initial value of last to 1
        int sum = 0;
        while (!stack.isEmpty() && stack.peek() <= target) {
            int cur = stack.pop();
            sum += last * cur;
            last = cur;
        }
        if (target != Integer.MAX_VALUE) { // Changed target value to Integer.MAX_VALUE
            sum += target * last;
            stack.push(target);
        }
        return sum;
    }
}
```