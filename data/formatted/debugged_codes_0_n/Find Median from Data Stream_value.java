```java
// Runtime: 183 ms (Top 63.96%) | Memory: 124.7 MB (Top 57.27%)
class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Pushing
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balancing
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {

        // Evaluating Median
        if (maxHeap.size() == minHeap.size()) { // Even Number
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else { // Odd Number
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek() + 0.0;
            } else { // minHeap.size() > maxHeap.size()
                return minHeap.peek() + 0.0;
            }
        }
    }
}
```