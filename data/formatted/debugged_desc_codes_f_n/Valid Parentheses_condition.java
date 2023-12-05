```java
// Runtime: 2 ms (Top 84.7%) | Memory: 40.80 MB (Top 15.0%)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) { // loop through each character in the string
            if (c == '(' || c == '{' || c == '[') // if the character is an opening parenthesis, brace, or bracket
                stack.push(c); // push it onto the stack
            else if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) // if the character is a closing parenthesis, brace, or bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
    
    // function to check if the pair of characters is matching
    private boolean isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }
}
```