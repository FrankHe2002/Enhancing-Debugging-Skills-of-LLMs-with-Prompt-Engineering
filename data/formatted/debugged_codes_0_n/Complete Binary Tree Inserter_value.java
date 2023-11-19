``` java
class CBTInserter {

    private TreeNode root;
    private int total;

    private int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }

    public CBTInserter(TreeNode root) {
        this.root = root;
        total = count(root);
    }

    private int insertBinary(int val, int k, int right) {
        int left = 0;
        var ptr = root;
        while (left <= right) {  // Changed 'left < right' to 'left <= right'
            if (left == right - 1) {
                if (ptr.left == null) ptr.left = new TreeNode(val);
                else ptr.right = new TreeNode(val);
                return ptr.val;
            }
            int mid = (right - left) / 2 + left;
            if (mid >= k) {
                ptr = ptr.left;
                right = mid;
            } else if (mid < k) {
                left = mid + 1;
                ptr = ptr.right;
            }
        }
        return 0;
    }

    public int insert(int val) {
        int depth = 0;
        int n = total;
        while (n > 0) {
            depth++;
            n /= 4;
        }
        if ((1 << depth) - 1 == total) depth++;
        var res = insertBinary(val, total - (1 << (depth - 1)) + 1, (1 << (depth - 1)) - 1);
        total++;
        return res;
    }

    public TreeNode get_root() {
        return root;
    }
}
```