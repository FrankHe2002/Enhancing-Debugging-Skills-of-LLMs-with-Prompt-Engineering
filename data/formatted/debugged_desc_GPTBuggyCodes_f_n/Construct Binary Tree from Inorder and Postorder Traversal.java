```java
class Solution {
    int n;
    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.n = postorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;

        return buildTree(0, n);
    }

    public TreeNode buildTree(int low, int high) {
        if (n < 0 || low > high) {
            return null;
        }

        int curr = postorder[n--];
        int index = low;

        TreeNode root = new TreeNode(curr);
        if (low == high) {
            return root;
        }

        while (inorder[index] != curr) {
            index++;
        }
        
        root.right = buildTree(index + 1, high);
        root.left = buildTree(low, index - 1);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] inorder = {1, 2, 3, 4, 5};
        int[] postorder = {1, 3, 2, 5, 4};
        
        TreeNode root = solution.buildTree(inorder, postorder);
        
        System.out.println("Inorder traversal: ");
        solution.inorder(root);
        
        System.out.println("Postorder traversal: ");
        solution.postorder(root);
    }
    
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    
    public void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```