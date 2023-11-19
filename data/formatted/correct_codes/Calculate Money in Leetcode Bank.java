class Solution {
    public int totalMoney(int n) {
        int m = n / 7;
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += 7 * (i + 3);
        }
        for (int i = 7 * m; i < n; i++) {
            res += ++ m;
        }
        return res;
    }
}