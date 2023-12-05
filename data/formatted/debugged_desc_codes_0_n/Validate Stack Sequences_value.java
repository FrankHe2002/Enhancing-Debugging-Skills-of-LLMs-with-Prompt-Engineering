```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>(); // Create a stack

        int j = 0; // Intialise one pointer pointing on popped array

        for (int val : pushed) {
            st.push(val); // insert the values in stack
            while (!st.isEmpty() && j < popped.length && st.peek() == popped[j]) { // if st.peek() values equal to popped[j];
                st.pop(); // then pop out
                j++; // increment j
            }
        }
        return j == popped.length && st.isEmpty(); // check if stack is empty and all elements of popped have been checked
    }
}
```