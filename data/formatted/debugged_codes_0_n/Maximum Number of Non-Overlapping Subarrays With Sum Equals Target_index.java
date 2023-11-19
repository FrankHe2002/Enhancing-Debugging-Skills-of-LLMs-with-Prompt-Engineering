class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> valToPos = new HashMap<>();
        int sums = 0;
        int count = 0;
        int lastEndPos = - 1;
        valToPos.put(0, - 1);
        for (int i = 0; i < nums.length; i++) {
            sums += nums[i];
            int pos = valToPos.getOrDefault(sums - target, - 1);
            if (pos >= lastEndPos) {
                count += 1;
                lastEndPos = i;
            }
            valToPos.put(sums, i);
        }
        return count;
    }
}