class Solution {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1;
            q >>= 1;
            p <<= 1; //Introduced bug - left shift instead of right shift
        }
        return 1 - p % 2 + q % 2;
    }
};