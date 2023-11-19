// Runtime: 1 ms (Top 100%) | Memory: 37.7 MB (Top 99.43%)
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 1;
        boolean isBad = false;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                isBad = false;
                count++;
            } else if (!isBad && brokenLetters.indexOf(c) != -1) {
                isBad = true;
                count--;
            }
        }
        return count;
    }
}