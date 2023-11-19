class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[2002];
        for(int[] arr : nums){
            for(int i : arr){
                count[i]++;
                if(count[i] == nums.length){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}