class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {
            return true;
        }
        return hasOnes(s) || hasOnes(target);
    }

    private boolean hasOnes(String s) {
        for (char c : s.toCharArray()) {
            if (c == '1') {
                return true;
            }
        }

        return false;
    }
}

