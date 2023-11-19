import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        int len3 = n / 3;
        long res = Long.MAX_VALUE;
        long[] first = new long[n];
        long[] second = new long[n];
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Comparator.reverseOrder());

        long sum = 0;
        for (int i = 0; i < len3; i++) {
            sum += nums[i];
            max.add(nums[i]);
        }
        for (int i = len3; i <= 2 * len3; i++) {
            first[i] = sum;
            max.add(nums[i]);
            sum += nums[i];
            sum -= max.poll();
        }
        sum = 0;
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        for (int i = 0; i < len3; i++) {
            sum += nums[n - 1 - i];
            min.add(nums[n - 1 - i]);
        }