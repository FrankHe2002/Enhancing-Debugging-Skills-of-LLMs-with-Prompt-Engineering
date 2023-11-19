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
            pq.add(a - (a + 1) / 2);
            res -= (a + 1) / 2;
        }
        return res;
    }
}