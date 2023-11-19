class Solution {
    public boolean winnerSquareGame(int n) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        memo.put(1, true);
        memo.put(0, false);
        List<Integer> perfectSquares = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            perfectSquares.add(i * i);
            i++;
        }
        perfectSquares.forEach(p -> memo.put(p, true));
        return this.playerWins(n, perfectSquares, memo);
    }

    private boolean playerWins(int n, List<Integer> P, HashMap<Integer, Boolean> m) {
        if (m.containsKey(n)) {
            return m.get(n);
        }
        m.put(n, false);
        for (Integer p : P) {
            if (p <= n && ! playerWins(n - p, P, m)) {
                m.put(n, true);
                break;
            }
        }
        return m.get(n);
    }
}