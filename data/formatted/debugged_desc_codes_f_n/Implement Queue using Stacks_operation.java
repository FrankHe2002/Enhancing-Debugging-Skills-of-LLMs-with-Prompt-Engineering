```java
// Runtime: 1 ms (Top 70.23+) | Memory: 41.5 MB (Top 77.34%)
class MyQueue {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> temp = new ArrayDeque<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
    }

    /**
     * Pushes element x to the back of the queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * @return the element at the front of the queue and remove it.
     */
    public int pop() {
        if(temp.isEmpty()){
            while (! stack.isEmpty())
                temp.push(stack.pop());
        }

        return temp.pop();
    }

    /**
     * @return the element at the front of the queue.
     */
    public int peek() {
        if(temp.isEmpty()){
            while (! stack.isEmpty())
                temp.push(stack.pop());
        }

        return temp.peek();
    }

    /**
     * @return true if the queue is empty, false otherwise.
     */
    public boolean empty() {
        return stack.isEmpty() && temp.isEmpty();
    }
}
```