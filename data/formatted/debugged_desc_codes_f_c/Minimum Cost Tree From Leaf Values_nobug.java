The bug in the provided code is in the `mctFromLeafValues` method, where the logic for finding the smallest possible sum of the values of each non-leaf node is not correctly implemented.
The algorithm in the provided code is hard to follow and creates unnecessary complexity. A simpler idea is to recognize that the minimum sum from non-leaf nodes corresponds to a form of transformation of the original array to binary trees, where smaller numbers at the ends of the array minimize the product of non-leaf nodes. This can be facilitated using a stack, allowing for easy access to the values of the leaves' parents. The current implementation does not consider the right logic for finding the minimum sum and the logic of pushing 17 into the stack during cleanUpStack is also not understood.

Here's the fixed code with a simpler and logically correct implementation:

```java
import java.util.Stack;

class Solution {
    public int mctFromLeafValues(int[] arr) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int num : arr) {
            while (stack.peek() <= num) {
                int mid = stack.pop();
                sum += mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }

        while (stack.size() > 2) {
            sum += stack.pop() * stack.peek();
        }
        return sum;
    }
}
```