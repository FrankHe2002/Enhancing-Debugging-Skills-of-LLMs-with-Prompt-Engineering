class Solution {
    public boolean checkZeroOnes(String s) {
        int length0 = 0;
        int length1 = 0;

        int i = 0;
        while (i < s.length()) {
            int temp = 0;
            while (i < s.length() && s.charAt(i) == '1') {
                temp++;
                i++;
            }
            length1 = Math.max(temp, length1);
            temp = 0;
            while (i < s.length() && s.charAt(i) == '0') {
                temp++;
                i++;
            }
            length0 = Math.max(temp, length0);
        }
        return length1 > length0;
    }
}