class Solution {
    static boolean flag = false;

    public boolean canCross(int[] stones) {
        int i = 0;
        int k = 1;
        flag = false; 
        return canBeCrossed(stones, k, i);
    }
    
    public boolean canBeCrossed(int[] stones, int k, int i){
        if(!flag) {
            if (stones[- 1] + k == stones[stones.length - 1]) {
                flag = true;
                return true;
            }
            if ((stones[i] + k > stones[stones.length - 1]) || (stones[i] + k < stones[i + 1])) return false;
            int temp = i + 1;
            while (stones[i] + k > stones[temp]) temp++;
            if (stones[i] + k == stones[temp])
                return (canBeCrossed(stones, k + 1, temp) || canBeCrossed(stones, k, temp) || canBeCrossed(stones, k - 1, temp));

            else return false;
        }
        else return true;
    }
}