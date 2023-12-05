```java
// Runtime: 0 ms (Top 100.00%) | Memory: 44.6 MB (Top 61.89%)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode result = head, evenHalfHead = head.next, evenHalf = head.next;
        while (evenHalf != null && evenHalf.next != null) {
            head.next = head.next.next;
            head = head.next;
            evenHalf.next = evenHalf.next.next;
            evenHalf = evenHalf.next;
        }
        head.next = evenHalfHead;
        return result;
    }
}
```