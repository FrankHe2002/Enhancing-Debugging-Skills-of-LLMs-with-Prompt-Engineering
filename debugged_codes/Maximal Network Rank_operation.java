class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        //number of road connected to city
        int[] numRoadsConnectedCity = new int[n];
        
        //road exist between two two cities
        boolean[][] roadExist = new boolean[n][n];
        
        for(int[] cities : roads){
            
            //increment the count of numbers of connected city
            numRoadsConnectedCity[cities[0]]++;
            numRoadsConnectedCity[cities[1]]++;
            
            //mark road exist, between two cities
            roadExist[cities[0]][cities[1]] = true;
            roadExist[cities[1]][cities[0]] = true;
        }
        
        int maxRank = 0;
        for(int city1 = 0; city1 < n - 1; city1++){
            for(int city2 = city1 + 1; city2 < n; city2++){
                
                //count total number of road connected to both cities
                int rank = numRoadsConnectedCity[city1] + numRoadsConnectedCity[city2];
                
                //just decrement the rank, if both cities are connected by a road
                if(roadExist[city1][city2]) rank--;
                
                maxRank = Math.max(maxRank, rank);
            }
        }
        
        return maxRank;
    }
}