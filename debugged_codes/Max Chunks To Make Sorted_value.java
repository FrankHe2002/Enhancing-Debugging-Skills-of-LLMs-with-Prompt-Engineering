// Runtime: 1 ms (Top 99.37%) | Memory: 38.9 MB (Top 27.17%)
class Solution {
    public int maxChunksToSorted(int[] arr) {

        int max=0, count=0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(arr[i],max);
            if(i<=max) count++;
        }return count;
    }
}