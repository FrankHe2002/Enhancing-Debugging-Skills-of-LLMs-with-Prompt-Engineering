class Solution {
    public int minOperations(String s) {
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i % 2 == 0 && s.charAt(i) == '0') || (i % 2 != 0 && s.charAt(i) == '1'))
                count1++;
            else if ((i % 2 == 0 && s.charAt(i) == '1') || (i % 2 != 0 && s.charAt(i) == '0'))
                count0++;
        }
        return Math.min(count0, count1);
    }
}