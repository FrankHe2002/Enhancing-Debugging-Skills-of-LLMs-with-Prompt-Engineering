class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        boolean even = true;
        while(qu.size()>0){
            int size = qu.size();
            int prev = (even)?0:Integer.MAX_VALUE;
            while(size-->0){
                TreeNode rem = qu.remove();
                if(even){
                    if(rem.val%2==0 || rem.val<=prev){
                        return false;
                    }
                }else{
                    if(rem.val%2!=0 || rem.val>prev){
                        return false;
                    }
                }
                if(rem.left!=null){
                    qu.add(rem.left); 
                }
                if(rem.right!=null){
                    qu.add(rem.right);
                }
                prev=rem.val;
            }
            even = !even;
        } 
        return true;
    }
}