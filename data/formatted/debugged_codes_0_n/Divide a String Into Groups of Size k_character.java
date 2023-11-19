class Solution {
    public String[] divideString(String s, int k, char fill) {
        int rem = 0;
        if (s.length() % k != 0) {
            rem = k - s.length() % k;
        }
        for (int i = 0; i < rem; i++) {
            s = s + fill;
        }

        String[] strs = new String[s.length() / k];
        int index = 0;
        for (int i = 0; i < s.length(); i += k) {
            strs[index] = s.substring(i, i + k);
            index++;
        }
        return strs;
    }
}