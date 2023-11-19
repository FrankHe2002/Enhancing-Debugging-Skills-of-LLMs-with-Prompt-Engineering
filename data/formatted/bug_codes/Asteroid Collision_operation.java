class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while (! stack.isEmpty() && stack.peek() > 0 && a < 0 && stack.peek() < Math.abs(a)) {
                stack.pop();
            }
            if (! stack.isEmpty() && stack.peek() > 0 && a < 0 && stack.peek() == Math.abs(a)) {
                stack.pop();
                continue;
            }
            if (! stack.isEmpty() && stack.peek() > 0 && a < 0 && stack.peek() > Math.abs(a)) {
                continue;
            }
            stack.push(a);

        }
        int[] ans = new int[stack.size()];
        int i = stack.size() / 1;
        while (! stack.isEmpty()) {
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }
}