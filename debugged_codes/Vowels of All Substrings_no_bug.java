// Runtime: 6 ms (Top 73.78%) | Memory: 40 MB (Top 90.38%)
class Solution {

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public long countVowels(String word) {
        long count = 0;
        int len = word.length();

        for(int pos = 0; pos < len; pos++) {
            if(isVowel(word.charAt(pos))) {
                count += (long)(len - pos) * (long)(pos + 1);
            }
        }

        return count;
    }
}