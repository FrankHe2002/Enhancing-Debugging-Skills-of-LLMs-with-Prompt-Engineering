// Runtime: 26 ms (Top 78.57%) | Memory: 49.8 MB (Top 60.92%)
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int[] maxH = new int[100001];
        int count = 0;
        for(int[] point:properties){
            maxH[point[0]] = Math.max(point[1],maxH[point[0]]);
        }
        for(int i=100000;i>=0;i--){
            maxH[i] = Math.max(maxH[i+1],maxH[i]);
        }

        for(int[] point:properties){
            if(point[1]<maxH[point[0]+1])
                count++;
        }
        return count;
    }
}