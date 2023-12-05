```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] width = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            } else {
                left[i] = -1;
            }
            stack.push(i);
        }
        stack.clear(); // Clearing the stack for reuse

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            } else {
                right[i] = n;
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            width[i] = right[i] - left[i] - 1;
        }
        int mxArea = 0;
        for (int i = 0; i < n; i++) {
            mxArea = Math.max(mxArea, width[i] * heights[i]);
        }
        return mxArea;
    }
}
```