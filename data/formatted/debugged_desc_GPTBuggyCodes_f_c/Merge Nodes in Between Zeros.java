The bug in the provided Java code is due to incorrect handling of linked list nodes. The method `mergeNodes` aims to merge consecutive integers between 0's into a single node with the sum and return the head of the modified linked list. However, it does not consider the special conditions of merged node creation and fails to adjust the pointers correctly. 

1. The `head` should not be considered in the loop iteration due to the mentioned condition that the starting point will have `Node.val == 0`.
2. The loop should iterate until the next value of current `temp` node becomes 0.
3. In order to sum the integers, the while condition and logic should be updated to split and merge the nodes accordingly.

The fixed Java code is as follows:

```java
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newList = new ListNode(0);
        ListNode newHead = newList;
        ListNode newtemp = newList;
        ListNode temp = head;
        int sum = 0;

        while (temp != null) {
            if (temp.val == 0) {
                if (sum > 0) {
                    ListNode node = new ListNode(sum);
                    newtemp.next = node;
                    newtemp = newtemp.next;
                    sum = 0;
                }
                if (temp.next != null) temp = temp.next; // Move to the next node
            } else {
                sum += temp.val;
                if (temp.next == null) {
                    ListNode node = new ListNode(sum);
                    newtemp.next = node;
                }
            }
            temp = temp.next;
        }
        return newHead.next;
    }
}
```