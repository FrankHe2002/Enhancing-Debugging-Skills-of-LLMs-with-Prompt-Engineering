The bug in the provided code is in the `while` loop that assigns the `random` pointers in the copied list. The condition `temp == null` is incorrect because it should be `temp != null`. Additionally, the order of the statements inside the loop should be rearranged to ensure that the `temp` pointer is updated before accessing its `random` pointer.

Fixed Code:
```java
class Solution {
    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        // node to be returned
        Node ans = new Node(head.val);

        // temporary pointer to the ans node
        Node tempAns = ans;

        Node temp = head;

        map.put(head, ans);
        temp = temp.next;

        // loop to store the lookalike new nodes of the original ones
        // create the new list side by side
        while (temp != null) {
            Node x = new Node(temp.val);
            map.put(temp, x);
            tempAns.next = x;
            tempAns = x;
            temp = temp.next;
        }

        // repointing them to the start
        temp = head;
        tempAns = ans;

        // will have lookup of O(1) for the random nodes
        while (temp != null) {
            tempAns.random = map.get(temp.random);
            temp = temp.next;
            tempAns = tempAns.next;
        }

        return ans;
    }
}
```