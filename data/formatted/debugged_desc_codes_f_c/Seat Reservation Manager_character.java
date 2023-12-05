The bug in the SeatManager class is the missing closing parenthesis after `int reserve` method definition which causes a compilation error.

Fix:
```java
// Runtime: 88 ms (Top 72.91%) | Memory: 105 MB (Top 67.49%)
class SeatManager {
    PriorityQueue<Integer> pq;
    int count;

    public SeatManager(int n) {
        count = 1;
        pq = new PriorityQueue();
    }

    public int reserve() {
        if (pq.size() == 0)
            return count++;

        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
```