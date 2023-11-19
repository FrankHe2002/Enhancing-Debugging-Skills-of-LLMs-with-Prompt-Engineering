class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (int i = 0; i <= patterns.length; i++) { // Subtle bug: Changed '<' to '<='
            if (word.contains(patterns[i])) {
                count++;
            }
        }
        return count;
    }
}