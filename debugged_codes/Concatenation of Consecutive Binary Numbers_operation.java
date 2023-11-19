// Runtime: 277 ms (Top 30.00%) | Memory: 117.4 MB (Top 18.57%)
class Solution {
    public int concatenatedBinary(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * (int) Math.pow(2, Integer.toBinaryString(i).length()) + i) % 1000000007;
        }
        return (int) res;
    }
}