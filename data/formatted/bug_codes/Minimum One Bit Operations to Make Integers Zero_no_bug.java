class Solution {
    public int minimumOneBitOperations(int n) {

        int inv = 0;
        for (; n != 0; n = n >> 1) {

            inv ^= n;
            System.out.println(inv + " " + n);
        }

        return inv;
    }
}