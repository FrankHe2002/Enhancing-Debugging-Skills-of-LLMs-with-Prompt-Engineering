```java
class MyQueue {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> temp = new ArrayDeque<>();

    public MyQueue() {
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        while (stack.size() > 1)
            temp.push(stack.pop());

        var val = stack.pop();
        while (! temp.isEmpty())
            stack.push(temp.pop());

        return val;
    }

    public int peek() {
        while (stack.size() > 1)
            temp.push(stack.pop());

        var val = stack.peek();
        while (! temp.isEmpty())
            stack.push(temp.pop());

        return val;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
```