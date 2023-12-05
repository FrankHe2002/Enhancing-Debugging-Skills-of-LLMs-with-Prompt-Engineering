```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int l = 0, r = 0;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        while (r < nums.length) {
            int n = nums[r++];
            while (!queue.isEmpty() && n > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offer(n);
            while (r - l >= k) {
                int m = nums[l++];
                if (m == queue.peekFirst()) {
                    res[index++] = m;
                    queue.pollFirst();
                }
            }
        }
        return res;
    }
}
```