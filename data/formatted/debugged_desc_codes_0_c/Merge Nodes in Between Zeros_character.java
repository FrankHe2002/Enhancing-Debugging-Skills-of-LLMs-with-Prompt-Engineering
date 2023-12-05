The given Java code has multiple bugs. 

1. The variable temp is initialized to head.next without checking if head is null. This will result in a NullPointerException when head is null.
2. The condition (head == null && head.next == null) is incorrect and should be (head == null || head.next == null) to check if either head or head.next is null.
3. The instantiation of a new ListNode inside the while loop should be after the condition (temp.val == 0) to create a new node after encountering a zero value.
4. There is a syntax error in the line ListNode node = new ListNode(sum; missing closing parenthesis.

Fixing the bugs:

```java
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newList = new ListNode(0);
        ListNode newHead = newList;
        ListNode newtemp = newList;

        if (head == null || head.next == null) return head;

        ListNode temp = head;
        int sum = 0;

        while (temp != null && temp.next != null) { // traverse linked list
            if (temp.val == 0) {
                newtemp.next = new ListNode(sum); // create a new node
                newtemp = newtemp.next; // shift pointer to newly created node
                sum = 0; // reset sum
            } else {
                sum += temp.val; // sum elements until zero
            }
            temp = temp.next;
        }

        return newHead.next; // skip dummy node which is created initially
    }
}
```

In this fixed code:
- The temp variable is initialized to head to avoid a NullPointerException.
- The condition for checking if head or head.next is null has been corrected.
- The instantiation of a new ListNode has been moved to the correct place and the syntax error has been fixed.