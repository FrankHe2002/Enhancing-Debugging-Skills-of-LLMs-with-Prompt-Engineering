class Solution {
    public int longestPalindrome(String[] words) {
        int[][] freq = new int[26][26];
        for (String word : words)
            freq[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        int left = 0;
        boolean odd = false;
        for (int i = 0; i != 26; i++) {
            odd |= (freq[i][i] & 1) == 1;
            left += freq[i][i] / 2;
            for (int j = i + 1; j != 26; j++)
                left += Math.min(freq[i][j], freq[j][i]);
        }
        int res = left * 2 * 2;
        if (odd) {
            res += 2;
        }
        return res;
    }
}