class NumArray {
    SegmentTree s;
    public NumArray(int[] nums) {
        s = new SegmentTree(nums);
        s.root = s.build(0, s.arr.length, s.arr);
    }
    
    public void update(int index, int val) {
        int oldvalue = s.arr[index];
        s.arr[index] = val;
        s.update(s.root, val, index, oldvalue);
    }
    
    public int sumRange(int left, int right) {
        return s.rangeSum(s.root, left, right);
    }
}

class Node {
    int s;
    int e;
    int val;
    Node left;
    Node right;
}

class SegmentTree {
    Node root;
    int[] arr;

    SegmentTree(int [] arr) {
        this.arr = arr;
    }

    public Node build(int start, int end, int[] arr) {
        Node temp = new Node();
        if (arr.length == 1) {
            temp.val = arr[0];
            temp.s = start;
            temp.e = end - 1;
        } else if (arr.length == 0 || start > end || start < 0 || end < 0) {
            return new Node();
        } else {
            temp.left = build(start, (start + end) / 2 + (arr.length % 2 == 1 ? 1 : 0), Arrays.copyOfRange(arr, 0, arr.length / 2 + (arr.length % 2 == 1 ? 1 : 0)));
            temp.right = build((start + end) / 2 + (arr.length % 2 == 1 ? 1 : 0), end, Arrays.copyOfRange(arr, arr.length / 2 + (arr.length % 2 == 1 ? 1 : 0), arr.length));
            temp.val = temp.left.val + temp.right.val;
            temp.s = start;
            temp.e = end - 1;
        }
        return temp;
    }
    
    public int rangeSum(Node node, int l, int r) {
        if (node == null) {
            return 0;
        }
        if (l <= node.s && node.e <= r) {
            return node.val;
        }
        int mid = (node.s + node.e) / 2;
        int left = 0;
        int right = 0;
        if (l <= mid) {
            left = rangeSum(node.left, l, r);
        }
        if (r >= mid) {
            right = rangeSum(node.right, l, r);
        }
        return (left + right);
    }

    public void update(Node root, int value, int idx, int oldvalue) {
        if (root == null) {
            return;
        }
        int mid = (root.e + root.s) / 2;
        if (idx <= root.e && idx >= root.s) {
            root.val -= oldvalue;
            root.val += value;
        }
        if (idx > mid) {
            update(root.right, value, idx, oldvalue);
        } else if (idx <= mid) {
            update(root.left, value, idx, oldvalue);
        }
    }
}
