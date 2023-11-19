Bug Type: Missing Semicolon

The bug in the provided code is that there is a missing semicolon (`;`) at the end of the statement `next = temp`. This results in a syntax error, causing compilation to fail.

To fix this bug, we simply need to add a semicolon at the end of the line `next = temp`.

Fixed Code:
```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.6 MB (Top 99.13%)

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
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode temp = null, next = curr.next;
        curr.next = null;

        while (curr != null && next != null) {
            // before cutting off link between next & its next, save next.next
            temp = next.next;
            // let next point to curr
            next.next = curr;

            curr = next;
            next = temp;

        }

        return curr;

    }
}
```