```java
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        if (!traversal.contains("-")) {
            return new TreeNode(Integer.parseInt(traversal));
        }
        String number = "";
        int i = 0;
        while (i < traversal.length() && traversal.charAt(i) != '-') {
            number += traversal.charAt(i);
            i++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(number));
        StringBuilder str = new StringBuilder();
        int bk = 0;
        for (int j = i; j < traversal.length(); j++) {
            if (j > 0 && traversal.charAt(j - 1) != '-' && traversal.charAt(j) == '-' && j + 1 < traversal.length() && traversal.charAt(j + 1) != '-') {
                bk = str.length();
            } else if (j > 0 && traversal.charAt(j - 1) != '-' && traversal.charAt(j) != '-') {
                str.append(traversal.charAt(j));
            }
        }
        String divide = str.toString();

        TreeNode left = (bk == 0) ? recoverFromPreorder(divide) : recoverFromPreorder(divide.substring(0, bk));
        TreeNode right = (bk == 0) ? null : recoverFromPreorder(divide.substring(bk, divide.length()));
        root.left = left;
        root.right = right;

        return root;
    }
}
```