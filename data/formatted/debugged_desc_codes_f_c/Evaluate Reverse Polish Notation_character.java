```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String i : tokens) {
            if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int temp = 0;
                if (i.equals("+"))
                    temp = b + a; // Change the expression to b + a to correctly perform the calculation for addition and subtraction
                else if (i.equals("-"))
                    temp = b - a;
                else if (i.equals("*"))
                    temp = a * b;
                else if (i.equals("/"))
                    temp = b / a;
                stack.push(temp);
            } else
                stack.push(Integer.parseInt(i));
        }
        return stack.pop(); // Change stack.pop) to stack.pop() to correct the method invocation
    }
}
```