The bug in the provided code is that the middle node is not correctly calculated when the size of the linked list is odd. 
To fix the bug, we need to modify the middle calculation code.

Here's the modified code:

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
```

Explanation:

1. We create two pointers, `slow` and `fast`, both initially point to the head of the linked list.
2. We move `fast` pointer by two nodes and `slow` pointer by one node each time in the while loop until `fast` reaches the end of the list or the next node of `fast` is null.
3. When `fast` reaches the end of the list or the next node of `fast` is null (indicating the list has an odd number of nodes), `slow` will be pointing to the middle node.
4. We return the `slow` pointer as the result.

By using this approach, we can find the middle node in a linked list in a single pass.