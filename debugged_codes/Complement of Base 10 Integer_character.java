// Runtime: 1 ms (Top 20.2%) | Memory: 39.34 MB (Top 43.8%)

class Solution {
    public int bitwiseComplement(int n) {
        String bin = Integer.toBinaryString(n);
        StringBuilder res = new StringBuilder();
        for (char c : bin.toCharArray()) {
            if (c == '1')
                res.append('0');
            else
                res.append('1');
        }
        return Integer.parseInt(res.toString(), 2);
    }
}