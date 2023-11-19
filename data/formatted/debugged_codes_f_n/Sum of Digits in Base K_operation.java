// Runtime: 0 ms (Top 100.00%) | Memory: 35.6 MB (Top 6.33%)
class Solution {
    public int sumBase(int n, int k) {
        int res = 0;
        for (; n > 0; n /= k)
            res += n % k;
        return res;
    }
}