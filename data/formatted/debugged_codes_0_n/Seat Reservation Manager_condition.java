```java
// Runtime: 85 ms (Top 76.57%) | Memory: 105.5 MB (Top 55.07%)
class SeatManager {
    PriorityQueue<Integer> pq;
    int count;

    public SeatManager(int n) {
        count = 1;
        pq = new PriorityQueue();
    }

    public int reserve() {
        if (pq.size() != 0)
            return pq.poll();

        return count++;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
```