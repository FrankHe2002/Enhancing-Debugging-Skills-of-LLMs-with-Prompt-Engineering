class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIdx = - 1;
        int lastMatch = - 1;

        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) ||
                    p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIdx = j;
                lastMatch = i;
                j++;
            } else if (starIdx != - 1) {
                j = starIdx + 1;
                lastMatch++;
                i = lastMatch;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') j++;

        if (i != s.length() || j != p.length()) return false;

        return true;
    }
}