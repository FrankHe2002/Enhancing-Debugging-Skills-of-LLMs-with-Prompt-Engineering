```java
class Solution {

    private boolean DFS(TreeNode currNode, StringBuilder path, int destVal) {
        if (currNode == null) return false;
        path.append("U");
        if (currNode.val == destVal) return true;
        if (DFS(currNode.left, path, destVal)) {
            path.append("L");
            return true;
        }
        if (DFS(currNode.right, path, destVal)) {
            path.append("R");
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
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
        
        String sPath = startToRoot.reverse().substring(cnt, startToRoot.length());
        String ePath = endToRoot.substring(cnt, endToRoot.length());
        
        return sPath + ePath;
    }
}
```