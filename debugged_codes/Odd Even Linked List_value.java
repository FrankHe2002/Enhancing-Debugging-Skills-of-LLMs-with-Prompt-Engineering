class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode result = head, evenHalf = new ListNode(0), evenHalfPtr = evenHalf;
        while (head.next != null) {
            evenHalfPtr.next = head.next;
            head.next = head.next.next;
            evenHalfPtr.next.next = null;
            if (head.next == null) {
                break;
            }
            evenHalfPtr = evenHalfPtr.next;
            head = head.next;
        }
        head.next = evenHalf.next;
        return result;
    }
}