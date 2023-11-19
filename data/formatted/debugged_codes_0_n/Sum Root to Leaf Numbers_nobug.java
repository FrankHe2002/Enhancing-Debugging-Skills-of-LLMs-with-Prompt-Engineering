```java
class Solution {
    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        if (root != null) {
            getSum(root, 0);
        }

        return res;
    }

    public void getSum(TreeNode root, int sum) {
        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            res += sum;
        }

        if (root.left != null) {
            getSum(root.left, sum);
        }

        if (root.right != null) {
            getSum(root.right, sum);
        }
    }
}
```