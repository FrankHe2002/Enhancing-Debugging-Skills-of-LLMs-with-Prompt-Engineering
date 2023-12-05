The code looks mostly correct, but there seems to be an issue comparing the values in the priority queues. The priority queues are not defined with a specific data type, which could lead to a bug in the comparison and ordering of the elements.

To fix the issue, we need to define the priority queues with the Integer data type to avoid any typecasting issues and potential comparison problems.

Here's the modified code:

```java
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {

        //Pushing
        if (maxHeap.isEmpty() || maxHeap.peek() < num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        //Balancing
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {

        //Evaluating Median
        if (maxHeap.size() == minHeap.size()) { // Even Number
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else { //Odd Number
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek() + 0.0;
            } else { // minHeap.size() > maxHeap.size()
                return minHeap.peek() + 0.0;
            }
        }
    }
}
```

With these changes, the code should work correctly and be less prone to potential comparison issues.