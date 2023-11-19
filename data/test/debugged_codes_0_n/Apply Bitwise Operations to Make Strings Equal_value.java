// Runtime: 0 ms (Top 100.0%) | Memory: 37 MB (Top 100.0%)

class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {     // if already equal
            return true;
        }
        // if both have 1s, return true, otherwise false
        return hasOnes(s) && hasOnes(target);
    }
    
    // method to check if the string has 1s
    private boolean hasOnes(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                return true;
            }
        }
        
        return false;
    }
}

// TC: O(n), SC: O(1)