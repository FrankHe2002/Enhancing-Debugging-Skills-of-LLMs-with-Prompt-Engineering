```java
// Runtime: 37 ms (Top 99.55%) | Memory: 47.2 MB (Top 22.41%)

class RecentCounter {
    Queue<Integer> calls;

    public RecentCounter() {
        calls = new LinkedList<>();
    }

    public int ping(int t) {
        calls.add(t);
        while (calls.peek() < t - 3000) {
            calls.poll();
        }
        return calls.size();
    }
}

/**
 / Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
```