```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                tortoise = head;
                while (tortoise != hare) {
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
                return hare;
            }
        }
        return null;
    }
}
```