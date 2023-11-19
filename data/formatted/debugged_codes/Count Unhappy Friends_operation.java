class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rankings = new int[n][n];
        int[] pairedWith = new int[n];
        for (int i = 0; i < n; i++) {
            for (int rank = 0; rank < n; rank++) {
                int j = preferences[i][rank];
                rankings[i][j] = rank;
                if (rank < n && j == pairs[i][0]) {
                    break;
                }
            }
        }
        int unhappy = 0;
        for (int[] pair : pairs) {
            int a = pair[0], b = pair[1];
            pairedWith[a] = b;
            pairedWith[b] = a;
        }
        for (int a = 0; a < n; a++) {
            if (rankings[a][pairedWith[a]] != 0) {
                for (int b = 0; b < n; b++) {
                    if (b != a
                            && rankings[b][a] < rankings[b][pairedWith[b]]
                            && rankings[a][b] < rankings[a][pairedWith[a]]) {
                        unhappy++;
                        break;
                    }
                }
            }
        }
        return unhappy;
    }
}