```java
class Solution {

    private boolean DFS(TreeNode currNode, StringBuilder path, int destVal) {
        if (currNode == null) return false;
        if (currNode.val == destVal) return true;
        boolean left = DFS(currNode.left, path, destVal);
        boolean right = DFS(currNode.right, path, destVal);
        if (left) path.append("L");
        else if (right) path.append("R");
        return left || right;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startToRoot = new StringBuilder();
        StringBuilder endToRoot = new StringBuilder();

        DFS(root, startToRoot, startValue);
        DFS(root, endToRoot, destValue);

        int i = startToRoot.length(), j = endToRoot.length();
        int cnt = 0;
        while (i > 0 && j > 0 && startToRoot.charAt(i - 1) == endToRoot.charAt(j - 1)) {
            cnt++;
            i--;
            j--;
        }

        String sPath = "U".repeat(startToRoot.length() - cnt);
        String ePath = endToRoot.reverse().toString().substring(cnt, endToRoot.length());

        return sPath + ePath;
    }
}
```