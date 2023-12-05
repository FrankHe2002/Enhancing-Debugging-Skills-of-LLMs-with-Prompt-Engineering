```java
class BSTIterator {

    TreeNode root;
    TreeNode current;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.current = findLeft(root);
    }

    public int next() {
        int val = -1;
        if (current != null) {
            val = current.val;
            if (current.right != null)
                current = findLeft(current.right);
            else
                current = nextElement(current);
        }
        return val;
    }

    public TreeNode findLeft(TreeNode node) {
        if (node.left == null) {
            return node;
        } else {
            return findLeft(node.left);
        }
    }

    public TreeNode nextElement(TreeNode node) {
        while (node != null) {
            if (node.val <= current.val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return node;
    }

    public boolean hasNext() {
        return current != null;
    }
}
```