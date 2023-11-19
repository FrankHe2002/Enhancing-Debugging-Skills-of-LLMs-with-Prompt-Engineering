```java
// Runtime: 55 ms (Top 94.3%) | Memory: 53.5 MB (Top 14.26%)

class RecentCounter {
    ArrayList<Integer> calls;

    public RecentCounter() {
        calls = new ArrayList<Integer>();
    }

    public int ping(int t) {
        calls.add(t);
        int count = 0;
        for (int i = calls.size() - 1; i >= 0; i--) {
            if (t - calls.get(i) <= 3000) {
                count++;
            } else {
                break;
            }
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