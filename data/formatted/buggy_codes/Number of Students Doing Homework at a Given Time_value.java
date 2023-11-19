class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = -1;
        for (int i = 0; i < startTime.length; ++ i) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) ++ count;
        }
        return count;
    }
}
