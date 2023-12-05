```java
class MKAverage {
    private TreeMap<Integer, Integer> map;
    private Deque<Integer> queue;
    private int m, k;
    private long sum;

    public MKAverage(int m, int k) {
        this.map = new TreeMap<>();
        this.queue = new LinkedList<>();
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        if (queue.size() == m) {
            int old = queue.removeFirst();
            map.put(old, map.get(old) - 1);
            if (map.get(old) == 0) map.remove(old);
        }
        queue.addLast(num);
        map.put(num, map.getOrDefault(num, 0) + 1);
        sum += num;
    }

    public int calculateMKAverage() {
        if (queue.size() < m) return -1;
        int l = 0, r = 0;
        long temp = 0L;
        for (int i : queue) {
            temp += i;
            if (++l > k) {
                int x = queue.get(r++);
                temp -= x;
            }
            if (l > k) temp -= map.higherKey(map.firstKey());
            if (l >= m - k) return (int) ((temp - sum) / (m - 2 * k));
        }
        return -1;
    }
}
```