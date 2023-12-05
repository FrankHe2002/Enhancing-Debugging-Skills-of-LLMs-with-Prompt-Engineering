```java
// Runtime: 183 ms (Top 63.97%) | Memory: 124.7 MB (Top 57.27%)
class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {

        //Pushing
        if (maxHeap.isEmpty() || ((int) maxHeap.peek() < num)) {
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
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        } else { //Odd Number
            if (maxHeap.size() > minHeap.size()) {
                return (double) maxHeap.peek();
            } else { // minHeap.size() > maxHeap.size()
                return (double) minHeap.peek();
            }
        }
    }
}
```