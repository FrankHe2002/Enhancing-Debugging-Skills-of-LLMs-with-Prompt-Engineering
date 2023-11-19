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
            segTree[index] = Math.max(segTree[2 * index + 1], segTree[2 * index + 2]);
            sum[index] = sum[2 * index + 1] + sum[2 * index + 2];
        }

        public void update(int pos, int val) {
            update(0, 0, n - 1, pos, val);
        }

        public int gatherQuery(int k, int maxRow) {
            return gatherQuery(0, 0, n - 1, k, maxRow);
        }

        private int gatherQuery(int index, int lo, int hi, int k, int maxRow) {
            if (segTree[index] < k || lo > maxRow)
                return - 1;
            if (lo == hi) return lo;
            int mid = (lo + hi) / 2;
            int c = gatherQuery(2 * index + 1, lo, mid, k, maxRow);
            if (c == - 1) {
                c = gatherQuery(2 * index + 2, mid + 1, hi, k, maxRow);
            }
            return c;
        }

        public long sumQuery(int k, int maxRow) {
            return sumQuery(0, 0, n - 1, k, maxRow);
        }

        private long sumQuery(int index, int lo, int hi, int l, int r) {
            if (lo > r || hi < l) return 0;
            if (lo >= l && hi <= r) return sum[index];
            int mid = (lo + hi) / 2;
            return sumQuery(2 * index + 1, lo, mid, l, r) + sumQuery(2 * index + 2, mid + 1, hi, l, r);
        }
    }

    SegTree segTree;
    int[] rowSeats;

    public BookMyShow(int n, int m) {
        segTree = new SegTree(n, m);
        rowSeats = new int[n];
        Arrays.fill(rowSeats, m);
    }

    public int[] gather(int k, int maxRow) {
        int row = segTree.gatherQuery(k, maxRow);
        if (row == - 1) return new int[] {};
        int col = segTree.m - rowSeats[row];
        rowSeats[row] -= k;
        segTree.update(row, rowSeats[row]);
        return new int[] {row, col};

    }

    public boolean scatter(int k, int maxRow) {
        long sum = segTree.sumQuery(0, maxRow);
        if (sum < k) return false;

        for (int i = 0; i <= maxRow && k != 0; i++) {
            if (rowSeats[i] > 0) {
                long t = Math.min(rowSeats[i], k);
                rowSeats[i] -= t;
                k -= t;
                segTree.update(i, rowSeats[i]);
            }
        }
        return true;
    }
}