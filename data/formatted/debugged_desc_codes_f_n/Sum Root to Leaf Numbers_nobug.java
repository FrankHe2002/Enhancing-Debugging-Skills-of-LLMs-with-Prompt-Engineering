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
        
        sum = sum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            res += sum;
            return;
        }

        getSum(root.left, sum);
        getSum(root.right, sum);
    }
}
```