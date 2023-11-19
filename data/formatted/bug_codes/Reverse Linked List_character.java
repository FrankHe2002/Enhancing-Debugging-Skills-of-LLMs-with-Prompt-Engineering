class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode temp = null, next = curr.next;
        curr.next = null;

        while (curr != null && next != null) {
            temp = next.next;
            next.next = curr;

            curr = next;
            next = temp;

        }

        return curr;

    }
}