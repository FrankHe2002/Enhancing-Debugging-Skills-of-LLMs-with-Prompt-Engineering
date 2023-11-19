```java
// Runtime: 1 ms (Top 99.97%) | Memory: 38.3 MB (Top 85.77%)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;

        if (head == null || head.next == null)
            return null;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        if (len == n)
            return head.next;

        int frontlen = len - n - 1;

        ListNode first = head.next;
        ListNode second = head;

        int count = 0;

        while (first != null) {
            if (count == frontlen) {
                second.next = first.next;
                break;
            } else {
                first = first.next;
                second = second.next;
                count++;
            }
        }

        return head;
    }
}
```