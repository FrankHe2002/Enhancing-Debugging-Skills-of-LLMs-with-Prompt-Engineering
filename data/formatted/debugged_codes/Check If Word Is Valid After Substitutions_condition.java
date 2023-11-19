import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'c') {
                if (stack.size() >= 2 && stack.pop() != 'b' && stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(arr[i]);
            }
        }
        return stack.size() == 0;
    }
}