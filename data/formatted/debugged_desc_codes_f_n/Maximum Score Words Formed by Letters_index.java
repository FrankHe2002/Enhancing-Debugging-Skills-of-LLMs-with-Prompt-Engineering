```java
// Runtime: 10 ms (Top 32.14%) | Memory: 44.3 MB (Top 16.39%)
class Solution {
    int[] memo;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        memo = new int[1 << words.length];
        Arrays.fill(memo, - 1);
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : letters) {
            int t = hm.getOrDefault(c, 0);
            t++;
            hm.put(c, t);
        }
        //return dp(words,hm,score,0,0);
        int res = dp(words, hm, score, 0, 0);
        //for(int i : memo) System.out.println(i);
        return res;
    }

    public int dp(String[] words, Map<Character, Integer> hm, int[] score, int mask, int cs) {//cs-current Score
        if (mask == (1 << words.length) - 1) return cs;
        if (memo[mask] != - 1) return memo[mask];
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            int tempScore = 0;
            boolean isValid = true;
            for (char c : words[i].toCharArray()) {
                if (hm.get(c) == null || hm.get(c) == 0) {
                    isValid = false;
                    break;
                }
                hm.put(c, hm.get(c) - 1);
                tempScore += score[c - 'a'];
            }
            if (isValid) {
                max = Math.max(max, tempScore + dp(words, hm, score, mask | (1 << i), cs + tempScore));
            }
            for (char c : words[i].toCharArray()) {
                hm.put(c, hm.get(c) + 1);
            }
        }
        memo[mask] = max;
        return max;
    }
}
```