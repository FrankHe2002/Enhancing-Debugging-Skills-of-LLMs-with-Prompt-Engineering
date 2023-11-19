class Solution {
    public int waysToMakeFair(int[] nums) {
        int count = 0;

        int evenLeft = 0;
        int oddLeft = 0;

        int evenRight = 0;
        int oddRight = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenRight += nums[i];
            } else {
                oddRight += nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                if (i % 2 == 0) {
                    oddLeft += nums[i - 1];
                } else {
                    evenLeft += nums[i - 1];
                }
            }
            if (i % 2 != 0) {
                evenRight -= nums[i];
            } else {
                oddRight -= nums[i];
            }
            if (evenLeft + oddRight == oddLeft + evenRight) {
                count++;
            }
        }
        return count;
    }
}

