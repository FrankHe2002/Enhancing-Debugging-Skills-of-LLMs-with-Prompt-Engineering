```java
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list1 = head;
        ListNode list2 = reverseList(slow.next);
        slow.next = null;
        while (list2 != null) {
            ListNode l1Next = list1.next;
            ListNode l2Next = list2.next;
            list1.next = list2;
            list2.next = l1Next;
            list1 = l1Next;
            list2 = l2Next;
        }
    }

    private ListNode reverseList(ListNode node) {
        if (node == null) return node;
        ListNode newHead = null, currNode = node;
        while (currNode != null) {
            ListNode backup = currNode.next;
            currNode.next = newHead;
            newHead = currNode;
            currNode = backup;
        }
        return newHead;
    }
}
```