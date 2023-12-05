```java
class Skiplist {
    private static class Node {
        private int value;
        private Node right, down;

        public Node(int value) {
            this.value = value;
        }
    }

    private static final double PROBABILITY = 0.5;
    private Node head;

    public Skiplist() {
        head = new Node(Integer.MIN_VALUE);
        head.right = new Node(Integer.MAX_VALUE);
        head.down = null;
        head.right.down = null;
    }

    public boolean search(int target) {
        return this.find(target).value == target;
    }

    public void add(int num) {
        Node cur = this.find(num);
        Node toAdd = new Node(num);
        toAdd.right = cur.right;
        cur.right = toAdd;
    }

    public boolean erase(int num) {
        Node cur = this.find(num);
        if (cur.right == null || cur.right.value != num) {
            return false;
        }
        cur.right = cur.right.right;
        return true;
    }

    private Node find(int target) {
        Node curr = head;
        while (curr != null) {
            while (curr.right != null && curr.right.value < target) {
                curr = curr.right;
            }
            if (curr.down != null) {
                curr = curr.down;
            } else {
                break;
            }
        }
        return curr;
    }
}
```