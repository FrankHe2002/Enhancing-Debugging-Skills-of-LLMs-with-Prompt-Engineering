```java
class FindElements {
    TreeNode tree, nodept;

    public FindElements(TreeNode root) {
        tree = root;
        tree.val = 0;
        go(tree);
    }

    void go(TreeNode node) {
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            go(node.left);
        }
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            go(node.right);
        }
    }

    public boolean find(int target) {
        return doit(target);
    }

    boolean doit(int target) {
        if (target == 0) {
            return true;
        }
        return doitRecursive(target, tree);
    }
    
    boolean doitRecursive(int target, TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.val == target) {
            return true;
        }
        return doitRecursive(target, node.left) || doitRecursive(target, node.right);
    }
}
```