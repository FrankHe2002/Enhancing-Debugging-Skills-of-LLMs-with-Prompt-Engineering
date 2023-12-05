```java
// Runtime: 2 ms (Top 39.54%) | Memory: 43.4 MB (Top 69.45%)
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        levelOrder(root, 0, result);
        return result;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (level == result.size())
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        levelOrder(root.left, level + 1, result);
        levelOrder(root.right, level + 1, result);
    }
}

```