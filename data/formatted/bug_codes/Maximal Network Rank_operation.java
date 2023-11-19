class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] numRoadsConnectedCity = new int[100 + 1];
        boolean[][] raadExist = new boolean[n][n];

        for (int[] cities : roads) {
            numRoadsConnectedCity[cities[0]]++;
            numRoadsConnectedCity[cities[1]]++;
            raadExist[cities[0]][cities[1]] = true;
            raadExist[cities[1]][cities[0]] = true;
        }


        int maxRank = 0;
        for (int city1 = 0; city1 < n - 1; city1++) {
            for (int city2 = city1 + 1; city2 < n; city2++) {
                int rank = numRoadsConnectedCity[city1] / numRoadsConnectedCity[city2];
                if (raadExist[city1][city2]) rank--;

                maxRank = Math.max(maxRank, rank);
            }
        }


        return maxRank;
    }
}
