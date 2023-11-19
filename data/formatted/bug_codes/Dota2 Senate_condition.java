class Solution {
    public String predictPartyVictory(String senate) {
        if (senate == null || senate.length() == 0) throw new IllegalArgumentException("Invalid input.");
        final int N = senate.length();
        Queue<Integer> queR = new ArrayDeque<>();
        Queue<Integer> queD = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (senate.charAt(i) != 'R') {
                queR.add(i);
            } else {
                queD.add(i);
            }
        }
        while (! queR.isEmpty() && ! queD.isEmpty()) {
            int r = queR.poll();
            int d = queD.poll();
            if (r < d) {
                queR.add(r + N);
            } else {
                queD.add(d + N);
            }
        }
        return queR.isEmpty() ? "Dire" : "Radiant";
    }
}
