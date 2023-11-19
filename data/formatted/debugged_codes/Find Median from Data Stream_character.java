class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || ((int) maxHeap.peek() > num)) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.peek());
            maxHeap.poll();
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.peek());
            minHeap.poll();
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((int) maxHeap.peek() + (int) minHeap.peek()) / 2.0;
        } else {
            if (maxHeap.size() > minHeap.size()) {
                return (int) maxHeap.peek() + 0.0;
            } else {
                return (int) minHeap.peek() + 0.0;
            }
        }
    }
}