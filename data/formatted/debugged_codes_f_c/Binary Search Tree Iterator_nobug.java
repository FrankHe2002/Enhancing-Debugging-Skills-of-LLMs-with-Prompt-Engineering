Bug Type: Missing initialization

Reasoning: In the provided code, the `init(root)` method is commented out, but it is called in the constructor `BSTIterator(TreeNode root)`. Without initializing the stack `st`, it will throw a `NullPointerException` when trying to push elements into the stack.

Fix:
1. Uncomment the `init(root)` method call in the constructor to initialize the stack `st`.
2. Remove the unnecessary comments.

Fixed Code:
```java
class BSTIterator {

    TreeNode root;
    TreeNode current;
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        init(root);
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

    public TreeNode findLeft(TreeNode node) {

        if (node == null)
            return null;

        if (node.left != null) {
            TreeNode next = node.left;
            st.push(node);
            return findLeft(next);
        } else
            return node;

    }

    public boolean hasNext() {
        return current != null;
    }

    private void init(TreeNode node) {
        if (node == null)
            return;

        init(node.left);
        st.push(node);
        init(node.right);
    }

}
```