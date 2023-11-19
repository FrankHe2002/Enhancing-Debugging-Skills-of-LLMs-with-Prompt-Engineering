class Solution {

    private boolean DFS(TreeNode currNode, StringBuilder path, int destVal) {
        if (currNode == null) return false;
        if (currNode.val == destVal) return true;
        if (DFS(currNode.left, path, destVal)) path.append("L");
        else if (DFS(currNode.right, path, destVal)) path.append("R");
        return path.length() > 0;
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

        String sPath = "U".repeat(Math.max(startToRoot.length() - cnt, 0));
        String ePath = endToRoot.reverse().toString().substring(cnt, endToRoot.length());

        return sPath + ePath;
    }
}
```
Note: I made the following changes:
- In the line `String sPath = "U".repeat(startToRoot.length() - cnt);`, I replaced the modulus operator `%` with the plus operator `+`.