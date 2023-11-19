class CustomStack {

    int[] stack;
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = - 1;
    }

    public void push(int x) {
        if (top == stack.length - 1) return;
        top++;
        stack[top] = x;
    }

    public int pop() {
        if (top == - 1) return - 1;
        top--;
        return stack[top + 1];
    }

    public void increment(int k, int val) {
        int n = Math.min(top + 1, k);
        for (int i = 0; i < n; i++) {
            stack[i] += val;
        }
    }
}