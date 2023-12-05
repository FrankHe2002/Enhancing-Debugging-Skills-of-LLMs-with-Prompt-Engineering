Bugs: 
1. There is a syntax error in the line `mQ.add(new height(b[2], b[0, true));`. The closing square bracket is missing after `b[0`.
2. The `getSkyline` method returns a list of lists of `Integer`, but the expected return type is a list of lists of `Integer` pairs.

Fix:
```java
class height implements Comparable<height> {
    int val = - 1;
    int pos = - 1;
    boolean isStart = false;

    height(int a, int b, boolean c) {
        val = a;
        pos = b;
        isStart = c;
    }

    public int compareTo(height h) {
        if (this.pos != h.pos)
            return this.pos - h.pos;
        if (isStart)
            return - 1;
        if (h.isStart)
            return 1;

        return this.val - h.val;
    }
}

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<height> mQ = new PriorityQueue<>();
        int len = buildings.length;
        for (int[] b : buildings) {
            mQ.add(new height(b[2], b[0], true));
            mQ.add(new height(b[2], b[1], false));
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.add(0);
        int prevHeight = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (!mQ.isEmpty()) {
            height h = mQ.poll();
            if (h.isStart) {
                heap.offer(h.val);
            } else {
                heap.remove(h.val);
            }

            int currentHeight = heap.peek();
            if (prevHeight != currentHeight) {
                List<Integer> lst = new ArrayList<>();
                lst.add(h.pos);
                lst.add(currentHeight);
                res.add(lst);
                prevHeight = currentHeight;
            }
        }
        return res;
    }
}
```