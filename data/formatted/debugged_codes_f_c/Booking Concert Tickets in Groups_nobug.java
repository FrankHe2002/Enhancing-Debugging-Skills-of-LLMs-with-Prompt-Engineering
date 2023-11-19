Bug Type Explanation:
The bug in the provided code is a missing semicolon (`;`).

Bug Fix Explanation:
The missing semicolon in the code is in the line `result += c`. To fix the bug, we simply need to add a semicolon at the end of the line.

Fixed Code:
```java
// Runtime: 221 ms (Top 91.46%) | Memory: 140.4 MB (Top 35.37%)
class BookMyShow {
    /**
     * Segment tree class to store sum of a range and maximum available seats in a row
     **/
    static class SegTree {
        long sum[]; // store sum of seats in a range
        long segTree[]; // store maximum seats in a range
        int m, n;

        public SegTree(int n, int m) {
            this.m = m;
            this.n = n;
            segTree = new long[4 * n];
            sum = new long[4 * n];
            build(0, 0, n - 1, m);
        }

        private void build(int index, int lo, int hi, long val) {
            if (lo == hi) {
                segTree[index] = val; // initialize segement tree with initial seat capacity
                sum[index] = val; // initialize "sum" with initial seat capacity of a row
                return;
            }
            int mid = (lo + hi) / 2;
            build(2 * index + 1, lo, mid, val); // build left sub tree
            build(2 * index + 2, mid + 1, hi, val); // build right sub tree
            segTree[index] = Math.max(segTree[2 * index + 1], segTree[2 * index + 2]); // maximum seats in a row for subtrees
            sum[index] = sum[2 * index + 1] + sum[2 * index + 2]; // sum of seats in a range
        }

        private void update(int index, int lo, int hi, int pos, int val) {
            /**
             Method to update segment tree based on the available seats in a row
             **/
            if (lo == hi) {
                segTree[index] = val;
                sum[index] = val;
                return;
            }
            int mid = (lo + hi) / 2;
            if (pos <= mid) { //