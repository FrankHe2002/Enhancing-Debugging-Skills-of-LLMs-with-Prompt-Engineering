class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long anstillnow = -1;
        long left = 1, right = 100000000000001L;
        
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long currTrips = 0;
            
            for(int t : time) {
                currTrips += mid / t;
            }
            
            if(currTrips >= totalTrips) {
                anstillnow = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return anstillnow;        
    }
}