class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode temp = null;
        ListNode next = curr.next;
        curr.next = null;

        while (next != null) {
            temp = next.next;
            next.next = curr;

            curr = next;
            next = temp;
        }

        return curr;

    }
}