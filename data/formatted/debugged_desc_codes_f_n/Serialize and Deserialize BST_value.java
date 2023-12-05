```java
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder string = new StringBuilder();
        serializeHelper(root, string);
        return string.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder string) {
        if (root == null) {
            return;
        }
        string.append(root.val).append(",");
        serializeHelper(root.left, string);
        serializeHelper(root.right, string);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] dataArr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));

        for (int i = 1; i < dataArr.length; i++) {
            deserializeHelper(root, Integer.parseInt(dataArr[i]));
        }
        return root;
    }

    private void deserializeHelper(TreeNode root, int digit) {
        if (digit > root.val) {
            if (root.right != null) {
                deserializeHelper(root.right, digit);
            } else {
                root.right = new TreeNode(digit);
            }
        } else {
            if (root.left != null) {
                deserializeHelper(root.left, digit);
            } else {
                root.left = new TreeNode(digit);
            }
        }
    }
}
```