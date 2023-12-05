```java
// Runtime: 2 ms (Top 84.7%) | Memory: 40.80 MB (Top 15.0%)

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) { // loop through each character in the string
            if (c == '(' || c == '{' || c == '[') { // if the character is an opening parenthesis, brace or bracket
                stack.push(c); // push it onto the stack
            } else { // if the character is a closing parenthesis, brace or bracket
                if(stack.isEmpty()) { // if the stack is empty, the closing bracket is unmatched, so return false
                    return false;
                }
                char top = stack.pop(); // get the top of the stack
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    // if the current closing bracket doesn't match the top of the stack, return false
                    return false;
                }
            }
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
}
```