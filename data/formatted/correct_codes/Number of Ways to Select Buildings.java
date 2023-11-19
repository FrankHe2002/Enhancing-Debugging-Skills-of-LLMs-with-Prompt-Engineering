class Solution {
    public long numberOfWays(String s) {
        int zero = 0;
        long zeroOne = 0;
        int one = 0;
        long oneZero = 0;
        long tot = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zero++;
                if (one > 0)
                    oneZero += one;
                if (zeroOne > 0)
                    tot += zeroOne;
            } else {
                one++;
                if (zero > 0)
                    zeroOne += zero;
                if (oneZero > 0)
                    tot += oneZero;
            }
        }
        return tot;
    }
}
