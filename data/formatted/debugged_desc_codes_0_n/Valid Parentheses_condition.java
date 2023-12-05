```java
// Runtime: 2 ms (Top 84.7%) | Memory: 40.80 MB (Top 15.0%)

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) { // loop through each character in the string
            if (c == '(' || c == '{' || c == '[') { // if the character is an opening parenthesis, brace, or bracket
                stack.push(c); // push the opening character onto the stack
            } else if (stack.isEmpty() || !isMatching(stack.pop(), c)) { // if the character is a closing parenthesis, brace, or bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
            }
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
    
    private boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') || (opening == '{' && closing == '}') || (opening == '[' && closing == ']');
    }
}
```