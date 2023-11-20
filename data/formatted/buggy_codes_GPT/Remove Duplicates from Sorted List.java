class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode result = head;

        while (result != null) {
            if (result.next == null) {
                break;
            }

            if (result.val == result.next.val) {
                result = result.next.next;
            } else {
                result = result.next;
            }
        }

        return head;
    }
}