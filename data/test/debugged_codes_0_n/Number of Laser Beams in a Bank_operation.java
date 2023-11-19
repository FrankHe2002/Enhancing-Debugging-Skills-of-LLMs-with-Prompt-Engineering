// Runtime: 1 ms (Top 56.45%) | Memory: 39 MB (Top 44.52%)
class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0, pre = 0;
        for (int i = 0; i < bank.length; i++) {
            int n = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    n++;
                }
            }
            if (n == 0) {
                continue;
            }
            ans += pre * n;
            pre = n;
        }
        return ans;
    }
}