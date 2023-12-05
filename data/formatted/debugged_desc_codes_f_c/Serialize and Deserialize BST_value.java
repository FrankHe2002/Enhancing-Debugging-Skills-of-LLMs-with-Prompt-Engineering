```java
import java.util.Arrays;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder string = new StringBuilder();
        traverse(root, string);
        return string.toString();
    }

    private void traverse(TreeNode root, StringBuilder string) {
        if (root == null) return;
        string.append(root.val).append(",");
        traverse(root.left, string);
        traverse(root.right, string);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] dataArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        for (int i = 1; i < dataArr.length; i++) {
            insert(Integer.parseInt(dataArr[i]), root);
        }
        return root;
    }

    private TreeNode insert(int digit, TreeNode node) {
        if (node == null) {
            return new TreeNode(digit);
        }
        if (digit < node.val) {
            node.left = insert(digit, node.left);
        } else {
            node.right = insert(digit, node.right);
        }
        return node;
    }
}
```