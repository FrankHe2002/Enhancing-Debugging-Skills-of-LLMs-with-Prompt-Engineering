The bug in the provided code is in the `push` method. The current implementation defeats the purpose of using two queues as it is creating a temporary queue within the `push` method. The correct implementation should only use two queues throughout all the methods, without creating a new queue every time an element is pushed.

Here's the revised code with the bug fixed:

```java
class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        top = x;
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        int temp = top;
        queue1.remove();
        if (!queue1.isEmpty()) {
            top = queue1.peek();
        }
        return temp;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
```

In the fixed code:
1. We have two queue variables `queue1` and `queue2` for creating the stack.
2. The `push` method pushes the new element onto `queue2`, and then moves all elements from `queue1` to `queue2`, making `queue2` the new primary queue.
3. In the `pop` method, we retrieve the top element before removing it, and update the `top` variable if `queue1` is not empty after the pop operation.
4. The `top` method simply returns the value of `top`.
5. The `empty` method checks if `queue1` is empty.

This implementation fixes the bug of creating a new queue within the `push` method and correctly uses only two queues throughout all the stack operations.