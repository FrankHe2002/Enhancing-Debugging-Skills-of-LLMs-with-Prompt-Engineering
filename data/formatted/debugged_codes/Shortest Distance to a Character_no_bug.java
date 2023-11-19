class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int index = - 1;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                index = i;
            }

            if (index == - 1) {
                ans[i] = Integer.MAX_VALUE;
            } else {
                ans[i] = i - index;
            }
        }

        index = - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                index = i;
            }

            if (index != - 1) {
                ans[i] = Math.min(ans[i], index - i);
            }
        }
        return ans;
    }
}