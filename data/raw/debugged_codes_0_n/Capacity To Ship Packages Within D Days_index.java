class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(weight, left);
            right += weight;
        }
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(weights, days, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    
    public boolean isPossible(int [] weights, int days, int mid) {
        int totalDays = 1;
        int totalWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            totalWeight += weights[i];
            if (totalWeight > mid) {
                totalDays++;
                totalWeight = weights[i]; 
            } 
            if (totalDays > days) {
                return false;
            }
        }
        return true;
    }
}