public class Solution {
    public int reverseBits(int n) {
        int mask = 0;
        int smask = 0;
        int j = 0;
        int rev = 0;
        for (int i = 31; i >= 0; i--) {
            mask = 1 << i;
            if ((mask & n) != 0) {
                smask = 1 << j;
                rev = rev | smask;
            }
            j++;
        }
        return rev;
    }
}
