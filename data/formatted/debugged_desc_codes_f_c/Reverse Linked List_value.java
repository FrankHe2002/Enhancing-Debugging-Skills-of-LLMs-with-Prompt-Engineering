Explanation:
The code runs into a `NullPointerException` for the case where the input list has only one node. An additional check for this specific case is needed.

Fix:
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode temp = null, next = curr.next;
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
```