class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }

        int[] map = new int[26];
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(map, 0);
            for (int j = i; j < n; j++) {
                map[s.charAt(j) - 'a']++;
                if (isValid(s, i, j, k, map)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    private boolean isValid(String s, int left, int right, int k, int[] map) {
        int numLetters = 0;
        int numLettersAtLeastK = 0;
        for (int num : map) {
            if (num > 0) {
                numLetters++;
            }

            if (num >= k) {
                numLettersAtLeastK++;
            }
        }

        return numLettersAtLeastK == numLetters && numLettersAtLeastK == right - left + 1;
    }
}