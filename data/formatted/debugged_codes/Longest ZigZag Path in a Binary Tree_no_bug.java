class Solution {
    static class Pair {
        int left = - 1;
        int right = - 1;
        int maxLen = 0;
    }

    public int longestZigZag(TreeNode root) {
        Pair ans = longestZigZag_(root);
        return ans.maxLen;
    }

    public static Pair longestZigZag_(TreeNode root) {
        if (root == null)
            return new Pair();
        Pair l = longestZigZag_(root.left);
        Pair r = longestZigZag_(root.right);

        Pair myAns = new Pair();
        myAns.left = l.right + 1;
        myAns.right = r.left + 1;
        int max = Math.max(myAns.left, myAns.right);
        myAns.maxLen = Math.max(max, Math.max(l.maxLen, r.maxLen));
        return myAns;

    }

}