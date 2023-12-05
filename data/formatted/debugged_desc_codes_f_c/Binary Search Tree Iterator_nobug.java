```java
class BSTIterator {

    TreeNode root;
    TreeNode current;
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        current = findLeft(root);
    }

    public int next() {
        int val = -1;
        if (current != null)
            val = current.val;
        else
            return -1;

        if (current.right != null)
            current = findLeft(current.right);
        else if (!st.isEmpty())
            current = st.pop();
        else
            current = null;

        return val;
    }

    // Method to find the leftmost node in the tree
    private TreeNode findLeft(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            TreeNode next = node.left;
            st.push(node);
            return findLeft(next);
        } else {
            return node;
        }
    }

    public boolean hasNext() {
        return current != null;
    }
}
```