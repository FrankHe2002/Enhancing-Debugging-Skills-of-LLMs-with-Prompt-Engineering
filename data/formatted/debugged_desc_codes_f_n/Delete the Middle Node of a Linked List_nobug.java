Fix:
```java
// Runtime: 0 ms | Memory: 38.3 MB
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Base Condition
        if (head == null || head.next == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
```