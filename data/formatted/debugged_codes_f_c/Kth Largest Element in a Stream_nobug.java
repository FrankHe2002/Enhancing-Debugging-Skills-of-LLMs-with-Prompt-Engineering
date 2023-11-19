Bug Type: Compilation Error

Reasoning: The code is missing generic type information for the PriorityQueue. The PriorityQueue should be parameterized with the type of elements it holds. In this case, it should be `PriorityQueue<Integer>`.

Fix:
```java
class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i : nums)
            add(i);
    }

    public int add(int val) {
        if (k > queue.size())
            queue.add(val);
        else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}
```