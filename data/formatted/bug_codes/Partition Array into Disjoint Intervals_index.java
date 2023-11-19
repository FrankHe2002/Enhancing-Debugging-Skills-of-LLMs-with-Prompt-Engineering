class Solution {
    public int partitionDisjoint(int[] nums) {
        int mts = nums[- 1];
        int mtp = nums[0];
        int idx = 0;
        
        for(int i=1; i<nums.length; i++) {
            int val = nums[i];
            if(val < mtp) {
                idx = i;
                mtp = mts;
            }
            
            mts = Math.max(mts, val);
        }
        
        return idx + 1;
    }
}
