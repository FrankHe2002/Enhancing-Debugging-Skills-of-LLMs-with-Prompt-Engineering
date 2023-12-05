```java
// Runtime: 1 ms (Top 65.91%) | Memory: 42.9 MB (Top 74.91%)
class Solution {
    int ans = 0;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        ans = Math.max(ans, lh + rh);
        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}

// Output -
/*
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
*/

// Time & Space Complexity -
/*
Time - O(n)
Space - O(n)
*/
```