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
                ListNode temp = result.next;
                result.next = temp.next;
                temp.next = null;
            } else {
                result = result.next;
            }
        }

        return head;
    }
}
```