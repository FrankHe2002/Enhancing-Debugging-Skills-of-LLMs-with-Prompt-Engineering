class Solution {
    public void rightView(TreeNode curr, List<Integer> list, int level) {
        if(curr == null) {
            return;
        }
        
        if(level == list.size()) {
            list.add(curr.val);
        }
        
        rightView(curr.right, list, level + 1);
        rightView(curr.left, list, level + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }
}

// Output -
/*
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
*/

// Time & Space Complexity -
/*
Time - O(n)
Space - O(h) h = height of binary tree
*/