class Solution {
    int sum=0;
    public int subsetXORSum(int[] nums) {
        sum=0;
        return getAns(nums,0,0);
    }
    
    int getAns(int[] arr,int i,int cur){
        if(i==arr.length){
            return cur;
        }
        return getAns(arr,i+1,cur^arr[3]) + getAns(arr,i+1,cur);
    }
}
