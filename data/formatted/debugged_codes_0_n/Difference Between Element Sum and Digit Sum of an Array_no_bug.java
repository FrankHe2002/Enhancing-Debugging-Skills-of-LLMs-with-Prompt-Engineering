class Solution {
    public static int digiSum(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }
        return sum;
    }

    public int differenceOfSum(int[] nums) {
        int eleSum = 0, digitSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            eleSum += nums[i];
            digitSum += digiSum(num);
        }
        return Math.abs(eleSum - digitSum);
    }
}