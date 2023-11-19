// Runtime: 16 ms (Top 14.31%) | Memory: 78.2 MB (Top 11.46%)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int ind = Math.abs(nums[i])-1;
            if(nums[ind]<0){
                ans.add(Math.abs(nums[i]));
            }
            else{
                nums[ind] = -1*nums[ind];
            }
        }
        return ans;
    }
}