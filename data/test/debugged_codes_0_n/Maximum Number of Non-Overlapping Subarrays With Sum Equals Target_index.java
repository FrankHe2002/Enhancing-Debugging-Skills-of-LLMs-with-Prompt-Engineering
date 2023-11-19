// Runtime: 11 ms | Memory: 47.6 MB
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> valToPos = new HashMap<>();
        int sums = 0;
        int count = 0;
        int lastEndPos = -1; // Fixed, should be -1 instead of 0
        valToPos.put(0, -1); // Fixed, should be -1 instead of 0
        for (int i = 0; i < nums.length; i++) {
            sums += nums[i]; // Fixed, should be nums[i] instead of nums[count]
            int pos = valToPos.getOrDefault(sums - target, -1);
            if (pos >= lastEndPos) {
                count += 1;
                lastEndPos = i;
            }
            valToPos.put(sums, i);
        }
        return count;
    }
}