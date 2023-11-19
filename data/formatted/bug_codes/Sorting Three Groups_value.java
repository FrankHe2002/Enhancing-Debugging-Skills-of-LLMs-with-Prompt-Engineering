class Solution {
    public int minimumOperations(List<Integer> nums) {
        int min = Integer.MAX_VALUE;

        int n = nums.size();
        for (int one = - 1; one < n; one++) {
            for (int three = one + 1; three <= n; three++) {
                min = Math.min(min, computeOperations(one, three, nums));
            }
        }
        return min;
    }

    int computeOperations(int one, int three, List<Integer> nums) {
        int count = 0;

        for (int i = 1; i < nums.size(); i++) {
            Integer pos = nums.get(i);
            if (i <= one) {
                if (pos != 1) count++;
            } else if (i < three) {
                if (pos != 2) count++;
            } else {
                if (pos != 3) count++;
            }

        }

        return count;
    }
}