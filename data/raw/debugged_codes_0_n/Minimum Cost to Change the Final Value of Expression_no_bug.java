import java.util.Stack;

class Solution {
    int index = 0;
    
    static class Pair {
        char val;
        int min;

        public Pair(char val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    
    public boolean convert(char c) { 
        return c == '1'; 
    }
    
    public char convertBack(boolean val) { 
        return (val) ? '1' : '0'; 
    }
         
    public Pair min(String given) {
        Stack<Pair> stack = new Stack<>();
        
        while(index < given.length()) {
            if(given.charAt(index) == '(') {
                index++;
                stack.push(min(given));
            }
            else if(given.charAt(index) == ')') {
                index++;
                return stack.pop();
            }
            else {
                stack.push(new Pair(given.charAt(index++), 1));
            }
            
            if(stack.size() == 3) {
                Pair curr = stack.pop();
                int min = 1;
                char val;
                if(stack.peek().val == '|') {
                    Pair prev = stack.pop();
                    val = convertBack(convert(curr.val) || convert(prev.val));
                    
                    if(curr.val != prev.val) min = 1;
                    else if(prev.val == '0'){
                        min = Math.min(curr.min, prev.min);
                    }
                    else{
                        min = 1 + Math.min(curr.min, prev.min);
                    }
                }
                else {
                    Pair prev = stack.pop();
                    val = convertBack(convert(curr.val) && convert(prev.val));
                    if(curr.val != prev.val) min = 1;
                    else if(prev.val == '1'){
                        min = Math.min(curr.min, prev.min);
                    }
                    else{
                        min = 1 + Math.min(curr.min, prev.min);
                    }
                }
                
                stack.push(new Pair(val, min));
            }
        }
        return stack.pop();
    }
    
    
    public int minOperationsToFlip(String expression) {
        if(expression.length() == 1) {
            return 1;
        }
        if(expression.charAt(0) == '(' && expression.length() == 3) {
            return 1;
        }
        
        return min(expression).min;
    }
}