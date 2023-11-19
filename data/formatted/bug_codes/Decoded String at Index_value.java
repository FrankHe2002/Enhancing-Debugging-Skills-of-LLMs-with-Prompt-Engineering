class Solution {
    public String decodeAtIndex(String s, int k) {
        long sz = 1;
        for (char ch : s.toCharArray()) {
            sz = Character.isDigit(ch) ? sz * (ch - '0') : ++ sz;
        }
        -- k;
        for (int i = s.length() - 1; true; i--){
            if (Character.isLetter(s.charAt(i)) && --sz == k) {
                return "" + s.charAt(i);
            }else if(Character.isDigit(s.charAt(i))){
                sz /= (s.charAt(i) - '0');
                k %= sz;
            }
        }
    }
}
