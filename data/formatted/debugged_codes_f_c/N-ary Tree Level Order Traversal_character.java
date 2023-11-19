The bug in the provided code is a syntax error caused by the missing closing brace (`}`) for the `levelOrder` method. 

To fix the bug, we need to add the missing closing brace at the end of the `levelOrder` method.

Fixed Code:
```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return result;
        helper(root, 0);
        return result;
    }
    
    private void helper(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            helper(child, level + 1);
        }
    }
}
```