```java
// Runtime: 29 ms (Top 75.56%) | Memory: 52.2 MB (Top 77.99%)
class FindElements {
    TreeNode tree, nodept;

    public FindElements(TreeNode root) {
        tree = root;
        tree.val = 0;
        recoverTree(tree);
    }

    void recoverTree(TreeNode node) {
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            nodept = node.left;
            recoverTree(node.left);
        }

        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            nodept = node.right;
            recoverTree(node.right);
        }
    }

    public boolean find(int target) {
        return isTargetPresent(target);
    }

    boolean isTargetPresent(int target) {
        if (target == 0) {
            nodept = tree;
            return true;
        }
        boolean f = isTargetPresent((target - 1) / 2);
        if (!f) {
            return false;
        }
        if (nodept.left != null && nodept.left.val == target) {
            nodept = nodept.left;
        } else if (nodept.right != null && nodept.right.val == target) {
            nodept = nodept.right;
        } else f = false;
        return f;
    }
}
```