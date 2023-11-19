// Runtime: 2 ms (Top 84.7%) | Memory: 40.80 MB (Top 15.0%)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); 
        for (char c : s.toCharArray()) { 
            if (c == '(')  
                stack.push(')'); 
            else if (c == '{') 
                stack.push('}'); 
            else if (c == '[')  
                stack.push(']'); 
            else if (stack.isEmpty() || stack.pop() != c)  
                return false;
        }
        return stack.isEmpty();
    }
}