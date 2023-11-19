The bug in the provided code is that it does not update the previous pointer of the last node in the child list before merging it with the next node.

To fix this bug, we need to update the previous pointer of the last node in the child list to point to the previous node before merging it with the next node.

Here is the fixed code:

```java
// Runtime: 0 ms (Top 100.00%) | Memory: 40.2 MB (Top 95.78%)
class Solution {
    public Node flatten(Node head) {
        Node curr = head; // for traversal
        Node tail = head; // for keeping the track of previous node
        Stack<Node> stack = new Stack<>(); // for storing the reference of next node when child node encounters
        while (curr != null) {
            if (curr.child != null) { // if there is a child
                Node child = curr.child; // creating a node for child
                if (curr.next != null) { // if there is list after we find child a child
                    stack.push(curr.next); // pushing the list to the stack
                    curr.next.prev = null; // pointing its previous to null
                }
                curr.next = child; // pointing the current's reference to child
                child.prev = curr; // pointing child's previous reference to current.
                curr.child = null; // pointing the current's child pointer to null
                
                // Fix: Update the previous pointer of the last node in the child list
                Node lastChild = child;
                while (lastChild.next != null) {
                    lastChild = lastChild.next;
                }
                lastChild.next = stack.isEmpty() ? null : stack.peek();
                if (lastChild.next != null) {
                    lastChild.next.prev = lastChild;
                }
            }
            tail = curr; // for keeping track of previous nodes
            curr = curr.next; // traversing
        }
        return head;
    }
}
```