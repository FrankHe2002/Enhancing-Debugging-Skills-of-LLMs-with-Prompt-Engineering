The bug type in the given Java code is a logical error. The code in the `findMedian` function uses integer division, which prevents an accurate median calculation as the division truncates. Another error is in the constructor, the PriorityQueue should be defined as follows:
```java
maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```
Explanation:
1. In the `MedianFinder` class, the original `maxHeap` initialization is incorrect. It requires a `Collections.reverseOrder()` comparator for the PriorityQueue to create a max-heap. This comparator orders the elements in reverse natural order, essential for the correct behavior of a max-heap.
2. The `findMedian` function has a logical error due to integer division using only integers disregarding remainders, which results in incorrect median calculations.

Fix:
```java
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
```

Optimization:
If all integer numbers from the stream are in the range [0, 100], the solution can be optimized:
- The maxHeap can store numbers from 0 to 100, and the minHeap can be used for numbers greater than 100.
- Using this optimization means that the addNum and findMedian calls would not require modification given the comparison and balancing conditions that are already in place.

If 99% of all integer numbers from the stream are in the range [0, 100], skipping seldom occuring large numbers from considering in minHeap will help in further optimization while keeping the same functions calls unchanged.