Code:
```java
public class Codec {
  
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder data = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    data.append("N");
                } else {
                    data.append(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
                data.append("e");
            }
        }
        return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split("e");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < nodes.length && !q.isEmpty()) {
            TreeNode node = q.poll();
            if (!nodes[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(node.left);
            }
            i++;
            if (!nodes[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
}
```