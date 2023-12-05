The bug in the code is in the while loop where the condition should be `num > 0` instead of `num >= 0` to avoid an infinite loop. Also, there is no need to re-insert the number into the string with a leading 0. 

Fix:
```java
class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> opq = new PriorityQueue<>();
        PriorityQueue<Integer> epq = new PriorityQueue<>();
        int bnum = num;
        while (num > 0) {
            int cur = num % 10;
            if (cur % 2 == 1) {
                opq.add(cur);
            } else {
                epq.add(cur);
            }
            num /= 10;
        }
        StringBuilder sb = new StringBuilder();
        num = bnum;
        while (num > 0) {
            int cur = num % 10;
            if (cur % 2 == 1)
                sb.insert(0, opq.poll());
            else
                sb.insert(0, epq.poll());
            num /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}
```