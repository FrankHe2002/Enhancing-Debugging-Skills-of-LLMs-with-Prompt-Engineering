The code provided above has a bug in the `build` method. When calling `StringBuilder sb = new StringBuilder(str).insert(2, String.valueOf(intToChar(root.val)));`, the index 2 should be replaced with the length of the string `str`.

To fix the bug, we need to replace the index 2 with `str.length()` so that the new characters are added at the end of the `str` StringBuilder. 

Here's the corrected code:

```java
class Solution {
    String result = null;

    public String smallestFromLeaf(TreeNode root) {
        build(root, new StringBuilder());
        return result;
    }

    public void build(TreeNode root, StringBuilder str) {
        if (root == null) return;

        StringBuilder sb = new StringBuilder(str).insert(str.length(), String.valueOf(intToChar(root.val)));

        if (root.left == null && root.right == null) { // we are on a leaf node
            result = result == null || sb.toString().compareTo(result) < 0 ? sb.toString() : result;
            return;
        }
        build(root.left, sb); // build left child
        build(root.right, sb); // build right child
    }

    // turns an int (0-25) into a Character ex: 0 -> a, 1 -> b, 2 -> c
    public Character intToChar(int i) {
        return (char) (i + 'a');
    }
}
```