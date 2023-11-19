```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        int length = 1;
        ListNode first = head;
        ListNode curr = head;
        ListNode node = head;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        
        node.next = head;  // fixed bug

        if (k == length) {
            return head;
        }

        int n = length - (k % length);
        for (int i = 0; i < n - 1; i++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}
```