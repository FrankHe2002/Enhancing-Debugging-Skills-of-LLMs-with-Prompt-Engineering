```java
// Runtime: 7 ms (Top 31.33%) | Memory: 218.3 MB (Top 51.88%)
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = slow.next;
        } else {
            head = head.next;
        }
        return head;
    }
}
```