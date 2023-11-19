```java
class Solution {
    // Utility Function of RightSideView
    public void rightView(TreeNode curr, List<Integer> list, int level) {
        // if, current is null, return
        if (curr == null) {
            return;
        }

        // if, level = list size
        // update the value at that level
        if (level == list.size()) {
            list.add(curr.val);
        } else {
            list.set(level, curr.val);
        }

        // recursive call for right side view
        rightView(curr.right, list, level + 1);
        // recursive call for left side view
        rightView(curr.left, list, level + 1);
    }

    // Binary Tree Right Side View Function
    public List<Integer> rightSideView(TreeNode root) {
        // create a list
        List<Integer> result = new ArrayList<>();
        // call right view function
        rightView(root, result, 0);
        return result;
    }
}
```