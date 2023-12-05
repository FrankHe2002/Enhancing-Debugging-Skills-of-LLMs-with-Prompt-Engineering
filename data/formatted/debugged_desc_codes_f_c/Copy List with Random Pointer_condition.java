The bugs in the code are as follows:
1. The condition in the while loop where the random pointers are assigned should be `temp != null` instead of `temp == null`.
2. The while loop to point the random nodes to their corresponding new nodes needs to have a null check for `temp` before assigning the random pointer to `tempAns`.
3. The copyRandomList function is missing the class definition for the Node class.

The fixed Java code:
```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = getClonedNode(map, oldNode.random);
            newNode.next = getClonedNode(map, oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(head);
    }

    public Node getClonedNode(HashMap<Node, Node> map, Node node) {
        if (node != null) {
            if (!map.containsKey(node)) {
                map.put(node, new Node(node.val));
            }
            return map.get(node);
        }
        return null;
    }
}
```