```java
// Runtime: 12 ms (Top *%) | Memory: 44.32 MB (Top *%)

class Solution {

    ListNode head = null;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode p = this.head;
        int i = 1, ans = 0;
        while (p != null) {
            if (Math.random() * i < 1) ans = p.val; // replace ans with i-th node.val with probability 1*i
            p = p.next;
            i++;
        }
        return ans;
    }
}
```