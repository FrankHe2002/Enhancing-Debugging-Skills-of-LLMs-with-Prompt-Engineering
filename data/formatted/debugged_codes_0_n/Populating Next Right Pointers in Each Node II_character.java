class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node head = null;
        Node prev = null;
        Node curr = root;

        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (head == null) {
                        head = curr.left;
                        prev = curr.left;
                    } else {
                        prev.next = curr.left;
                        prev = prev.next;
                    }
                }

                if (curr.right != null) {
                    if (head == null) {
                        head = curr.right;
                        prev = curr.right;
                    } else {
                        prev.next = curr.right;
                        prev = prev.next;
                    }
                }
                curr = curr.next;
            }

            curr = head;
            prev = null;
            head = null;
        }
        return root;
    }
}