class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0')
            return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int maxReach = 0;

        while (! queue.isEmpty()) {
            int idx = queue.remove();
            if (idx == s.length() - 1)
                return true;
            for (int j = Math.max(idx + minJump, maxReach); j <= Math.min(idx + maxJump, s.length() - 1); j++) {
                if (s.charAt(j) == '0')
                    queue.add(j);
            }
            maxReach = Math.min(idx + maxJump + 1, s.length() - 1);
        }

        return false;
    }
}
