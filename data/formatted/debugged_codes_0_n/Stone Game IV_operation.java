```java
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
        return playerWins(n, perfectSquares, memo);
    }

    private boolean playerWins(int n, List<Integer> perfectSquares, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, false);
        for (Integer p : perfectSquares) {
            if (p <= n && !playerWins(n - p, perfectSquares, memo)) {
                memo.put(n, true);
                break;
            }
        }
        return memo.get(n);
    }
}
```