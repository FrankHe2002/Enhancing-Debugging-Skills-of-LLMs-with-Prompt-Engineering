```java
class Solution {
    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        getSum(root, 0);

        return res;
    }

    public void getSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res += (sum * 10 + root.val);
        } else {
            getSum(root.left, sum * 10 + root.val);
            getSum(root.right, sum * 10 + root.val);
        }
    }
}
```