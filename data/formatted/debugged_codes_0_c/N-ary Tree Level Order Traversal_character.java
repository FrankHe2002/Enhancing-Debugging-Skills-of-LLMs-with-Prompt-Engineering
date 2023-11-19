The bug in the provided Java code is in the line `result.add(new ArrayList());`. The code is missing the type parameter for the ArrayList.

To fix this bug, we need to specify the type parameter for the ArrayList. In this case, the ArrayList is expected to hold integers, so we need to change the line to `result.add(new ArrayList<Integer>());`.

Here is the corrected code:

```java
class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return result;
        helper(root, 0);
        return result;
    }

    private void helper(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            helper(child, level + 1);
        }
    }
}
```