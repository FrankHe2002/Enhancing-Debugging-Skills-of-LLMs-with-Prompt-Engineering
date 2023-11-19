class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 1;
        ListNode curr = head;
        ListNode node = head;
        while (node.next != null) {
            length++;
            node = node.next;
        }

        int n = length - (k % length);
        for (int i = 0; i < n - 1; i++) {
            curr = curr.next;
        }

        node.next = head;
        head = curr.next;
        curr.next = null;

        return head;
    }
}