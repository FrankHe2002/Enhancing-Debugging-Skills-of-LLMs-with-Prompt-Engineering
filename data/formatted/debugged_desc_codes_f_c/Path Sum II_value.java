```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    public void pathSum(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val)//leaf node that completes path
        {
            ans.add(new ArrayList(path));// we use new ArrayList because if we don't the originaly List is added which is mutable, if we add a copy that's not mutable.
        } else {
            pathSum(root.left, targetSum - root.val, new ArrayList<>(path), ans); // create a new ArrayList for each recursive call
            pathSum(root.right, targetSum - root.val, new ArrayList<>(path), ans); // create a new ArrayList for each recursive call
        }
    }
}
```