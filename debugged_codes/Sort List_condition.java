// Runtime: 1 ms (Top 92.21%) | Memory: 47.5 MB (Top 68.33%)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middle(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // Create a dummy node
        ListNode tail = dummy; // Set tail as the dummy node
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) { // Changed >= to <=
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // Moved this line inside the loop
        }

        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next; // Return the next node of the dummy node
    }

    public ListNode middle(ListNode head) {
        ListNode slow = head; // Renamed midprev to slow
        ListNode fast = head; // Renamed head to fast
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
}