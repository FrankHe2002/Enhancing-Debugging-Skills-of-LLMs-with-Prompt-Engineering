// Runtime: 0 ms (Top 100.0%) | Memory: 36.9 MB (Top 97.9%)

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        subsets(nums, 0, 0);
        return count;
    }
    
    int count = 0;
    int maxOR = 0;
    
    private void subsets(int[] arr, int vidx, int OR) {
        if (vidx == arr.length) {
            if (OR == maxOR) {
                count++;
            } else if (OR > maxOR) {
                count = 1;
                maxOR = OR;
            }
            return;
        }
        
        subsets(arr, vidx + 1, OR | arr[vidx]); // include
        subsets(arr, vidx + 1, OR); // exclude
    }
}