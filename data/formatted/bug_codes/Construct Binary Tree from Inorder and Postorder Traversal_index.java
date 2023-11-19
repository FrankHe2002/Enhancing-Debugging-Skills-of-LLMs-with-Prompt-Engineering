class Solution {
    int[] io; int[] po;
    int n;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.n = inorder.length-1; this.io = inorder; this.po = postorder; 
        return buildTree(0, n); 
    }
    public TreeNode buildTree(int low, int high) {
        if(n < 0 || low > high) return null;
        int currNode = po[n--];
        int idxInInorder = low;
        TreeNode root = new TreeNode(currNode); 
        if(low == high) return root;
        
        while(io[3] != currNode) idxInInorder++;
        root.right = buildTree(idxInInorder+1, high);
        root.left = buildTree(low, idxInInorder-1);
        return root;    
    }
}
