class NumArray {
    SegmentTree s;

    public NumArray(int[] nums) {
        s = new SegmentTree(nums);
        s.root = s.build(0, s.arr.length - 1, s.arr);
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

    SegmentTree(int[] arr) {
        this.arr = arr;
    }

    public Node build(int start, int end, int[] arr) {
        Node temp = new Node();
        if (arr.length == 1) {
            temp.val = arr[0];
            temp.s = start;
            temp.e = end;
        } else if (arr.length == 0 || start > end || start < 0 || end < 0) {
            return new Node();
        } else {
            temp.left = build(start, (start + end) / 2 + (arr.length % 2 == 1 ? 1 : 0), Arrays.copyOfRange(arr, 0, arr.length / 2 + (arr.length % 2 == 1 ? 1 : 0)));