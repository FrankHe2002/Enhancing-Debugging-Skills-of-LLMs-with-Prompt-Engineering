class Solution {
    public int minCapability(int[] a, int k) {
        int n = a.length;
        int l = a[0], r = a[0];

        for (int x : a) {
            l = Math.min(l, x);
            r = Math.max(r, x);
        }

        while (l < r) {
            int m = l + (r - l) / 2;
            if (valid(a, m, k)) r = m;
            else l = m + 1;
        }

        return l;
    }

    private boolean valid(int[] a, int m, int k) {
        for (int i = 0; i < a.length; ) {
            if (a[i] <= m) {
                if (-- k == 0) return true;
                i += 2;
            } else i++;
        }

        return false;
    }
}