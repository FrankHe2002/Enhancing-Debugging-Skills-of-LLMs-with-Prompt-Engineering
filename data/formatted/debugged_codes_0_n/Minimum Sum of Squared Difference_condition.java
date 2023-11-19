```java
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long minSumSquare = 0;
        int[] diffs = new int[100_001];
        long totalDiff = 0;
        long kSum = k1 + k2;
        int currentDiff;
        int maxDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            currentDiff = Math.abs(nums1[i] - nums2[i]);
            if (currentDiff > 0) {
                totalDiff += currentDiff;
                diffs[currentDiff]++;
                maxDiff = Math.max(maxDiff, currentDiff);
            }
        }
        if (totalDiff <= kSum) {
            return 0;
        }
        for (int i = maxDiff; i > 0 && kSum > 0; i--) {
            if (diffs[i] > 0) {
                if (diffs[i] >= kSum) {
                    diffs[i] -= kSum;
                    diffs[i - 1] += kSum;
                    kSum = 0;
                } else {
                    diffs[i - 1] += diffs[i];
                    kSum -= diffs[i];
                    diffs[i] = 0;
                }
            }
        }

        for (int i = 0; i <= maxDiff; i++) {  // corrected i > maxDiff to i <= maxDiff
            if (diffs[i] > 0) {
                minSumSquare += (long) (Math.pow((long) i, 2)) * diffs[i];
            }
        }
        return minSumSquare;
    }
}
```