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
        }

        int longestLengthOfContinuousPositiveSequence = 0;

        for (int currentSlidingWindowLength = 1; currentSlidingWindowLength <= n; currentSlidingWindowLength++) {
            for (int i = 0; i <= n - currentSlidingWindowLength; i++) {
                int j = i + currentSlidingWindowLength - 1;
                int currentIntervalNoOfTiringDaysMinusNonTiringDays = prefixSumTiringDaysMinusNonTiringDaysArr[j + 1] - prefixSumTiringDaysMinusNonTiringDaysArr[i];
                if (currentIntervalNoOfTiringDaysMinusNonTiringDays > 0) {
                    longestLengthOfContinuousPositiveSequence = Math.max(currentSlidingWindowLength, longestLengthOfContinuousPositiveSequence);
                }
            }
        }

        int lengthOfLongestWellPerformingInterval = longestLengthOfContinuousPositiveSequence;

        return lengthOfLongestWellPerformingInterval;
    }
}
```