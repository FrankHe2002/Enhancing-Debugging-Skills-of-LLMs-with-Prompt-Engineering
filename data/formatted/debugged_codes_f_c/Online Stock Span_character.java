Bug type: Syntax Error

Reasoning: 
- The bug type is a syntax error because the provided Java code contains a missing semicolon (`;`) at the end of the statement `stack = new Stack<>()`.
- In Java, each statement should end with a semicolon to signify the end of the statement.
- Therefore, the missing semicolon causes a syntax error in the code.

Fix:
To fix the bug, add a semicolon at the end of the statement `stack = new Stack<>()`.

Final Fixed Code:
```java
import java.util.Stack;

class Pair {
    int stock;
    int span;

    public Pair(int stock, int span) {
        this.stock = stock;
        this.span = span;
    }

}

class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().stock <= price) {
            Pair pStock = stack.pop();
            span += pStock.span;
        }
        stack.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
```