```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        int length = 1;
        ListNode node = head;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        
        k = k % length; // Optimize the value of k.

        if (k == 0) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < k; i++) {
            second = second.next;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = head;
        head = first.next;
        first.next = null;

        return head;
    }
}
```