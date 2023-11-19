```java
class Solution {
    //global index to traverse given string. It is incremented in "min" function recursively.
    int index = 0;

    //Custom class to the value and the minimum flips required to change value for that value
    class Pair {
        char val;
        int min;

        public Pair(char val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    //helper function to convert '1' to true and '0' to false
    public boolean convert(char c) {
        return c == '1';
    }

    //helper function to convert true to '1' and false to '0'
    public char convertBack(boolean val) {
        return (val) ? '1' : '0';
    }

    //Funtion to return the pair of value of the given string and the minimum number of operations required to flip it
    public Pair min(String given) {
        Stack<Pair> stack = new Stack<>();

        //Loop 
        while (index < given.length()) {
            // If the char is '(', recursively call the min function and add the result to the stack. 
            if (given.charAt(index) == '(') {
                index++;
                stack.push(min(given));
            }

            // If the char is ')', then we have processed an expression and the top of the stack will have the expression's final value and the min number of operations required to flip it.
            else if (given.charAt(index) == ')') {
                index++;
                return stack.pop();
            }

            //If the char is '|' or '&' or '1' or '0', add it to the stack
            else {
                //Minimum operation to flip any of these values is 1.
                stack.push(new Pair(given.charAt(index++), 1));
            }

            //CORE LOGIC START -> Explained in the "Intuition" part
            //If the stack size has reached 3, then we have completed an expression (i.e) 2 operands and one operator
            if (stack.size() == 3) {
                Pair curr = stack.pop();
                int min = 1;
                char val;
                if (stack.peek().val == '|') {
                    Pair prev = stack.pop();
                    val = convertBack(convert(curr.val) || convert(prev.val));

                    if (curr.val != prev.val) min = 1;
                    else if (prev.val == '0')