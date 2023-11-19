```java
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
                result.next = result.next.next; // Fixed bug: set result.next to result.next.next instead of modifying result
            } else {
                result = result.next;
            }
        }

        return head;
    }
}
```