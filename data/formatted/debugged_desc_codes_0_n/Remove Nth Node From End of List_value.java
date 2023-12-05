```java
// Runtime: 1 ms (Top 72.17%) | Memory: 42.2 MB (Top 52.36%)
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

        int frontlen = len - n;

        ListNode first = head;
        ListNode second = null;

        int count = 0;

        while (first != null) {
            if (count == frontlen) {
                if (second == null) {
                    return head.next;
                } else {
                    second.next = first.next;
                    break;
                }
            } else {
                second = first;
                first = first.next;
                count++;
            }
        }

        return head;
    }
}
```