class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] b = new int[26];
        int h = k / 26;
        int h1 = k % 26;
        for (int i = 0; i < 26; i++) {
            b[i] += h;
            if (i <= h1) b[i]++;
        }

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == t.charAt(i)) {
                i++;
            } else {
                int diff = ((t.charAt(i) - s.charAt(i)) + 26) % 26;
                b[diff]--;
                if (b[diff] < 0) return false;
                else i++;
            }
        }
        return true;
    }
}