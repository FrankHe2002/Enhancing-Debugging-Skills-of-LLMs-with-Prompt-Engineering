class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while (a <= b) {
            if (((a * a) + (b * b)) == c) {
                return true;
            } else if ((((a * a) + (b * b)) < c)) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}