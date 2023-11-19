import java.util.Arrays;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 1e9 + 7;
        int[] snums1 = nums1.clone();
        Arrays.sort(snums1);

        int maxDiff = 0;
        int pos = 0;
        int newn1 = 0;
        for (int i = 0; i < nums2.length; i++) {
            int n2 = nums2[i];
            int origDiff = Math.abs(nums1[i] - n2);
            int floor = arrayFloor(snums1, n2);
            if (floor > Integer.MIN_VALUE) {
                int newDiff = Math.abs(floor - n2);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = floor;
                    maxDiff = diff;
                }
            }
            int ceiling = arrayCeiling(snums1, n2);
            if (ceiling < Integer.MAX_VALUE) {
                int newDiff = Math.abs(ceiling - n2);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;