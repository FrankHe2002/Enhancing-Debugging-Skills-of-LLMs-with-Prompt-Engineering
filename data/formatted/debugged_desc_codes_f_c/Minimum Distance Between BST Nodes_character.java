```java
class Solution {

    int mini = Integer.MAX_VALUE;

    public void find(TreeNode root, ArrayList<Integer> arr) {

        if (root == null) {
            return;
        }
        
        find(root.left, arr);
        
        arr.add(root.val);
        
        for (int i = arr.size() - 2; i >= 0; i--) {

            mini = Math.min(mini, Math.abs(root.val - arr.get(i)));

        }
        
        find(root.right, arr);
    }

    public int minDiffInBST(TreeNode root) {

        ArrayList<Integer> arr = new ArrayList<>();
        find(root, arr);
        return mini;
        
    }
}
```