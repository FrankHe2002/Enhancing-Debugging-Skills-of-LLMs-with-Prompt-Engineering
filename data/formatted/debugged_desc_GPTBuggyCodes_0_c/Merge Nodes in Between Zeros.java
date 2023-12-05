The bug in the given code is that it does not consider the case where there are two consecutive 0's, and the sum of the nodes between these two 0's is not calculated.

Here's how to fix the bug:

1. Check for the base case where the head is null or the next node of the head is null. If true, return the head as it is.
2. Update the loop condition to iterate over the nodes properly.
3. Initialize the `temp` variable to the head, as we need to traverse the entire list
4. Keep track of the previous node separately to calculate the sum and merge nodes between two consecutive 0's.
5. Create a new node when two consecutive 0's are found and update the next and previous pointers accordingly.

Here's the fixed code in markdown:

```java
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        int sum = 0;
        
        while (current != null) {
            sum += current.val;
            if (current.val == 0) {
                prev.next = new ListNode(sum);
                sum = 0;
            } else {
                prev = current; // update the previous node
            }
            current = current.next;
        }
        return head.next;
    }
}
```