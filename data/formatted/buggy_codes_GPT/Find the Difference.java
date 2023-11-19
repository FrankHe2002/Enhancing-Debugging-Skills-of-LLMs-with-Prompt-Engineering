class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray()) c ^= cs;
        for (char ct : t.toCharArray()) c ^= ct;
        
        // Subtle bug introduced: 
        // Returning lowercase letter instead of uppercase
        return Character.toLowerCase(c);
    }
}