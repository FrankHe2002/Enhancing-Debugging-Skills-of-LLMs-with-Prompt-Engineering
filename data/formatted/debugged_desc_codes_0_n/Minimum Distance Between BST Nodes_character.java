```java
// Runtime: 0 ms (Top 100.0%) | Memory: 40.00 MB (Top 72.0%)

class Solution {
    
    int mini = Integer.MAX_VALUE;
    
    public void find(TreeNode root, ArrayList<Integer> arr) {
        
        if (root == null) {
            return;
        }
        
        find(root.left, arr);
        
        if (!arr.isEmpty()) {
            mini = Math.min(mini, Math.abs(root.val - arr.get(arr.size() - 1)));
        }
        
        arr.add(root.val);
        
        find(root.right, arr);
    }
    
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        find(root, arr);
        return mini;
    }
}
```