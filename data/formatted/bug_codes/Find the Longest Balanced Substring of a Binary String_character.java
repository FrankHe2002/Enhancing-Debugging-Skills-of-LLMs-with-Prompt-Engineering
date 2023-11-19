class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); ) {
            int z = 0, o = 0;
            while (i < s.length() && s.charAti) =='0'){
                z++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == '1' && z > o) {
                o++;
                i++;
                max = Math.max(max, o * 2);
            }
            while (i < s.length() && s.charAt(i) == '1') i++;
        }
        return max;
    }
}
