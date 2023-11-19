```java
// Runtime: 0 ms (Top 100.00%) | Memory: 38.9 MB (Top 91.59%)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode result = head, evenHalf = new ListNode(0), evenHalfPtr = evenHalf;
        while (head.next != null) {
            evenHalfPtr = evenHalfPtr.next = head.next;
            head.next = head.next.next;
            evenHalfPtr.next = null;
            if (head.next == null) {
                break;
            }
            head = head.next;
        }
        head.next = evenHalf.next;
        return result;
    }
}
```