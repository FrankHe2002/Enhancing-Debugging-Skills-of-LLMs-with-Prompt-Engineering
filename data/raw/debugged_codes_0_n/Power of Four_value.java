// Runtime: 1 ms (Top 98.49%) | Memory: 36 MB (Top 96.31%)
class Solution {
    public boolean isPowerOfFour(int n) {
        return (Math.log(n)/Math.log(4))%1==0;
    }
}