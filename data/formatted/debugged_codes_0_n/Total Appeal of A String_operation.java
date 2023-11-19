import java.util.Arrays;

class Solution {
    public long appealSum(String s) {
        long res = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] pos = new int[26];
        Arrays.fill(pos, - 1);
        for (int i = 0; i < n; ++ i) {
            int j = cs[i] - 'a';
            int prev = pos[j];
            if (prev != - 1) {
                res += (i - prev) * (long) (n - i);
            }
            pos[j] = i;
        }
        return res;
    }
}