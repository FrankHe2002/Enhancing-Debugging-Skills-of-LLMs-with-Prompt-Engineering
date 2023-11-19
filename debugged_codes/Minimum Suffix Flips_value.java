// Runtime: 2 ms (Top 99.35%) | Memory: 39.8 MB (Top 98.29%)

class Solution {
    public int minFlips(String target) {
        boolean lastBit = false;
        int flips = 0;
        for(int i=0; i<target.length(); i++){
            if(target.charAt(i) != (lastBit ? '1' : '0')){
                flips++;
                lastBit = !lastBit;
            }
        }
        return flips;
    }
}