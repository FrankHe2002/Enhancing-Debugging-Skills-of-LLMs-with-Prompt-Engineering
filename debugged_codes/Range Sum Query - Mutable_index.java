class NumArray {
    SegmentTree s;
    public NumArray(int[] nums) {
        s = new SegmentTree(nums);
        s.root = s.build(0, s.arr.length-1, s.arr);//build returns root Node of what it built
    }
    
    public void update(int index, int val) {
        int oldvalue = s.arr[index];//Find old value with traditional array, which is O(1) time complexity
        s.arr[index] = val;//Set our array so that there will be no contradictions if we ever rebuild.
        //If we are going use build function only once, then we don't need to update our traditional array. 
        s.update(s.root, val, index, oldvalue);//Call class' function
    }
    
    public int sumRange(int left, int right) {
        return s.rangeSum(s.root, left, right);
    }
}

class Node {
    int s;//inclusive label
    int e;//inclusive label
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
        //Start and End integers have nothing to do with building of our SegmentTree, you may ignore them for now
        //They are needed for querying and updating, so that we can use binary search.
        Node temp = new Node();
        if (arr.length == 1) {//which means we are setting a node equal to an element of arr
            temp.val = arr[0];
            temp.s = start;
            temp.e = end;//to make it inclusive
        } else if (arr.length == 0 || start > end || start < 0 || end < 0) {
            return new Node();// may be better
        } else {
            //left = build(start, mid but add 1 if array's length is not divisible by 2, left half of the passed array)
            temp.left = build(start, (start+end)/2 + (arr.length % 2 == 1 ? 1 : 0), Arrays.copyOfRange(arr, 0, arr.length/2 + (arr.length % 2 == 1 ? 1 : 0)));