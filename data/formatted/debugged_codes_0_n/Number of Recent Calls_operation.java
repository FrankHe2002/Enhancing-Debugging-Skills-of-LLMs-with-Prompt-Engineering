```java
// Runtime: 1373 ms (Top 10.1%) | Memory: 52.32 MB (Top 27.9%)

class RecentCounter {
    ArrayList<Integer> calls;

    public RecentCounter() {
        calls = new ArrayList<Integer>();
    }

    public int ping(int t) {
        calls.add(t);
        int count = 0;
        for (int i = calls.size() - 1; i >= 0; i--) {
            if (t - calls.get(i) <= 3000) count++;
        }
        return count;

    }
}

/**
 / Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
```