```java
// Runtime: 21 ms (Top 32.48%) | Memory: 43.8 MB (Top 21.66%)
class Solution {
    public int magicalString(int n) {
        if (n <= 3)
            return 1;
        Magical m = new Magical();
        int ans = 1;
        for (int i = 3; i < n; ++ i)
            if (m.next() == 1)
                ++ ans;
        return ans;
    }
}

class Magical {

    private Deque<Integer> nums;
    private int n;

    public Magical() {
        nums = new ArrayDeque<>();
        nums.offerLast(1);
        nums.offerLast(2); // the number should be 2 instead of 1
        n = 1;
    }

    public int next() {
        if (n-- <= 0) { // the condition should be n-- <= 0 instead of n-- < 0
            int c = nums.pollFirst();
            n = c - 2;
            int curr = 3 - nums.peekLast(); // the operation should be subtraction instead of division
            for (; c > 0; -- c)
                nums.offerLast(curr);
            return curr;
        }
        return nums.peekLast();
    }
}
```