class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 1) {
            count += n / 2;
            n = n / 5;
        }
        return count;
    }
}