```java
class Solution {

    public int longestWPI(int[] hours) {
        int n = hours.length;

        int[] prefixSumTiringDaysMinusNonTiringDaysArr = new int[n + 1];
        prefixSumTiringDaysMinusNonTiringDaysArr[0] = 0;

        int prefixSumTiringDaysCount = 0;
        int prefixSumNonTiringDaysCount = 0;

        for (int i = 0; i < n; i++) {
            int noOfHoursWorkedToday = hours[i];

            if (noOfHoursWorkedToday > 8) {
                prefixSumTiringDaysCount++;
            } else {
                prefixSumNonTiringDaysCount++;
            }

            prefixSumTiringDaysMinusNonTiringDaysArr[i + 1] = prefixSumTiringDaysCount - prefixSumNonTiringDaysCount;
            // System.out.print(prefixSumTiringDaysMinusNonTiringDaysArr[i] + " ");
        }
        // System.out.println(prefixSumTiringDaysMinusNonTiringDaysArr[n]);

        int longestLengthOfContinuousPositiveSequence = 0;

        // Fix the bounds of the sliding window
        for (int currentSlidingWindowLength = 1; currentSlidingWindowLength <= n; currentSlidingWindowLength++) {
            // System.out.print(currentSlidingWindowLength + " - ");
            // Use a separate variable for the right endpoint of the sliding window
            for (int right = currentSlidingWindowLength - 1; right < n; right++) {
                int left = right - currentSlidingWindowLength + 1;
                // System.out.print(left + "," + right + " ");
                int currentIntervalNoOfTiringDaysMinusNonTiringDays = prefixSumTiringDaysMinusNonTiringDaysArr[right + 1] - prefixSumTiringDaysMinusNonTiringDaysArr[left];
                if (currentIntervalNoOfTiringDaysMinusNonTiringDays > -1) { // => currentInterval = Well Performing Interval
                    longestLengthOfContinuousPositiveSequence = Math.max(currentSlidingWindowLength, longestLengthOfContinuousPositiveSequence);
                }
            }
            // System.out.println();
        }
        // System.out.println();

        int lengthOfLongestWellPerformingInterval = longestLengthOfContinuousPositiveSequence;

        return lengthOfLongestWellPerformingInterval;
    }

}
```