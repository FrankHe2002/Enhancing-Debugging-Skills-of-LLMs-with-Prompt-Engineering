class BookMyShow {
    static class SegTree {
        long sum[];
        long segTree[];
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
                segTree[index] = val;
                sum[index] = val;
                return;
            }
            int mid = (lo + hi) / 2;
            build(2 * index + 1, lo, mid, val);
            build(2 * index + 2, mid + 1, hi, val);
            segTree[index] = Math.max(segTree[2 * index + 1], segTree[2 * index + 2]);
            sum[index] = sum[2 * index + 1] + sum[2 * index + 2];
        }

        private void update(int index, int lo, int hi, int pos, int val) {
            if (lo == hi) {
                segTree[index] = val;
                sum[index] = val;
                return;
            }
            int mid = (lo + hi) / 2;
            if (pos <= mid) {
                update(2 * index + 1, lo, mid, pos, val);
            } else {
                update(2 * index + 2, mid + 1, hi, pos, val);
            }