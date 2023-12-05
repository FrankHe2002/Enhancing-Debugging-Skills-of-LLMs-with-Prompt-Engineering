```java
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newList = new ListNode(0);
        ListNode newHead = newList;
        ListNode newtemp = newList;
        ListNode temp = head;
        int sum = 0;
        if (head == null || head.next == null) {
            return head;
        }
        while (temp != null) {
            sum += temp.val;
            if (temp.val == 0) {
                ListNode node = new ListNode(sum);
                newtemp.next = node;
                newtemp = newtemp.next;
                sum = 0;
            }
            temp = temp.next;
        }
        return newHead.next;
    }
}
```