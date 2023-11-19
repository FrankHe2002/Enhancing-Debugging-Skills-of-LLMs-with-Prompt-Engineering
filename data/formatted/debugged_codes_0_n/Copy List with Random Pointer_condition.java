```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node ans = new Node(head.val);
        Node tempAns = ans;
        Node temp = head;

        map.put(head, ans);
        temp = temp.next;

        while (temp != null) {
            Node x = new Node(temp.val);
            map.put(temp, x);
            tempAns.next = x;
            tempAns = x;
            temp = temp.next;
        }

        temp = head;
        tempAns = ans;

        while (temp != null) {
            tempAns.random = map.get(temp.random);
            tempAns = tempAns.next;
            temp = temp.next;
        }

        return ans;
    }
}
```