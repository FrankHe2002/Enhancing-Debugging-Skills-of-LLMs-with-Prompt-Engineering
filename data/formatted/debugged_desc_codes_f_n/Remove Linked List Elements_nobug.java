Fix
```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode result = head;
        while (result.next != null) {
            if (result.next.val == val) {
                result.next = result.next.next;
            } else {
                result = result.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
```