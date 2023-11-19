class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = Integer.MAX_VALUE;
        int high = position[position.length - 1] - position[0];
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (blackbox(mid, position, m)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean blackbox(int maxPossibleDist, int[] position, int m) {
        int balls = 1;
        int prevballplace = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prevballplace >= maxPossibleDist) {
                prevballplace = position[i];
                balls++;
            }
        }
        return balls >= m;
    }
}