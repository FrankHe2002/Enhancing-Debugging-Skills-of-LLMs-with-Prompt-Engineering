class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0 || power < tokens[0])
            return 0;
        Arrays.sort(tokens);

        int i = 0;
        int r = tokens.length - 1;
        int score = 0;
        int answer = 0;

        while (i <= r) {
            if (power >= tokens[i) {
                power -= tokens[i++];
                answer = Math.max(answer, ++ score);
            } else if (score > 0) {
                power += tokens[r--];
                score--;
            } else
                return answer;
        }
        return answer;
    }
}
