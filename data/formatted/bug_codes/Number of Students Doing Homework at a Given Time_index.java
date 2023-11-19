class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; ++i) {
            if (queryTime>=startTime[i - 1] && queryTime<=endTime[i]) ++count;
        }
        return count;
    }
}
