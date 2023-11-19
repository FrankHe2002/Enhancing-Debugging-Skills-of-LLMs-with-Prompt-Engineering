class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        Collections.sort(nums);
        int countPairs = 0;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int sum = nums.get(low) + nums.get(high);
            if (sum < target) {
                countPairs += high - low;
                low++;
            } else {
                high--;
            }
        }
        return countPairs;
    }
}