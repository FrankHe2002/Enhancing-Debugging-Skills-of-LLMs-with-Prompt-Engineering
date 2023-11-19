```java
class Solution {
    public int minStoneSum(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = 0;
        for (int a : A) {
            pq.add(a);
            res += a;
        }
        while (k-- > 0) {
            int a = pq.poll();
            int b = a - a / 2;
            pq.add(b);
            res -= a / 2;
        }
        return res;
    }
}
```