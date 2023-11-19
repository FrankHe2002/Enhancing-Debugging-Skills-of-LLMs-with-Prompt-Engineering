class Solution {
    int[] memo;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        memo = new int[words.length];
        Arrays.fill(memo, - 1);
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : letters) {
            int t = hm.getOrDefault(c, 0);
            t++;
            hm.put(c, t);
        }
        return dp(words, hm, score, 0, 0);
    }

    public int dp(String[] words, Map<Character, Integer> hm, int[] score, int index, int cs) {
        if (index == words.length) return cs;
        if (memo[index] != - 1) return memo[index];
        HashMap<Character, Integer> temp = new HashMap<>(hm);
        int tcs = cs;

        for (char c : words[index].toCharArray()) {
            int t = temp.getOrDefault(c, 0);
            t--;
            if (t < 0) {
                return dp(words, hm, score, index + 1, cs);
            }
            tcs += score[c - 'a'];
            temp.put(c, t);
        }
        return Math.max(dp(words, hm, score, index + 1, cs), dp(words, temp, score, index + 1, tcs));
    }