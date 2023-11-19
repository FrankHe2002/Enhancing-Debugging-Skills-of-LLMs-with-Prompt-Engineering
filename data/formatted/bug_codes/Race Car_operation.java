class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 1, 0});
        Set<String> visited = new HashSet<>();

        while (! queue.isEmpty()) {
            int[] item = queue.poll();
            int currPos = item[0];
            int currSpeed = item[1];
            int distance = item[2];

            if (currPos == target)
                return distance;
            int nextPos = currPos + currSpeed;
            int nextSpeed = currSpeed * 2;
            String posSpeed = new StringBuilder().append(nextPos).append(",").append(nextSpeed).toString();
            if (! visited.contains(posSpeed) && Math.abs(nextPos) < 2 * target) {
                visited.add(posSpeed);
                queue.add(new int[] {nextPos, nextSpeed, distance + 1});
            }
            if ((currPos + currSpeed > target && currSpeed > 0) || (currPos + currSpeed < target && currSpeed < 0)) {
                nextSpeed = currSpeed > 0 ? - 1 : 1;
                posSpeed = new StringBuilder().append(currPos).append(",").append(nextSpeed).toString();

                if (! visited.contains(posSpeed) && Math.abs(currPos) < 2 * target) {
                    visited.add(posSpeed);
                    queue.add(new int[] {currPos, nextSpeed, distance - 1});
                }
            }
        }
        return - 1;
    }
}