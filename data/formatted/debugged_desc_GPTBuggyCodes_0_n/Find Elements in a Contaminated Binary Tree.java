```java
class FindElements {
    TreeNode tree, nodept;

    public FindElements(TreeNode root) {
        tree = root;
        tree.val = 0;
        recoverTree(tree);
    }

    public void recoverTree(TreeNode node) {
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            recoverTree(node.left);
        }
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            recoverTree(node.right);
        }
    }

    public boolean find(int target) {
        return isFound(target);
    }

    public boolean isFound(int target) {
        if (target == 0) {
            nodept = tree;
            return true;
        }
        boolean found = isFound((target - 1) / 2);
        if (!found) return false;
        if (nodept.left != null && nodept.left.val == target) {
            nodept = nodept.left;
        } else {
            if (nodept.right != null && nodept.right.val == target) {
                nodept = nodept.right;
            } else {
                found = false;
            }
        }
        return found;
    }
}
```