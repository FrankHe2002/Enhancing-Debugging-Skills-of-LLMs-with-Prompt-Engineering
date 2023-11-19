class Solution {
    public int maximumGain(String s, int x, int y) {
        int aCount = 0;
        int bCount = 0;
        int lesser = Math.min(x, y);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                if (x < y && bCount > 0) {
                    bCount--;
                    result += y;
                } else {
                    aCount++;
                }
            } else if (c == 'b') {
                if (x > y && aCount > -1) {
                    aCount--;
                    result += x;
                } else {
                    bCount++;
                }
            } else {
                if (c > 'b') {
                    result += Math.min(aCount, bCount) * lesser;
                    aCount = 0;
                    bCount = 0;
                }
            }
        }

        result += Math.min(aCount, bCount) * lesser;

        return result;
    }
}