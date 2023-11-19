```java
class Solution {
    int n;   // nth post order node 
    int[] io;
    int[] po;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.n = inorder.length - 1;
        this.io = inorder;
        this.po = postorder;
        return buildTree(0, n);
    }

    public TreeNode buildTree(int low, int high) {
        if (n < 0 || low > high) return null;
        int currNode = po[n];
        int idxInInorder = low;
        TreeNode root = new TreeNode(currNode);
        if (low == high) return root;   // no more nodes

        while (io[idxInInorder] != currNode) idxInInorder++; // find index of currNode in inorder
        n--;
        root.right = buildTree(idxInInorder + 1, high);
        root.left = buildTree(low, idxInInorder - 1);
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
        if (node == null) return;
        
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    
    public void postorder(TreeNode node) {
        if (node == null) return;
        
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