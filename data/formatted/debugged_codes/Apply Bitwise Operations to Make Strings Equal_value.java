class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {
            return true;
        }
        return hasOnes(s) && hasOnes(target);
    }

    private boolean hasOnes(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                return true;
            }
        }

        return false;
    }
}

