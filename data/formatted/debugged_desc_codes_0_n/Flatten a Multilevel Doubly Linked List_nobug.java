```java
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head; // for traversal
        while (curr != null) {
            if (curr.child != null) { // if there is a child
                Node child = curr.child; // creating a node for child
                Node next = curr.next; // store the reference to next node
                curr.next = child; // pointing the current's reference to child
                child.prev = curr; // pointing child's previous reference to current.
                curr.child = null; // pointing the current's child pointer to null
                Node childTail = child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
            }
            curr = curr.next; // traversing
        }
        return head;
    }
}
```