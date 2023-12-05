```java
// Runtime: 26 ms (Top 93.60%) | Memory: 51.8 MB (Top 51.74%)
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        char[] chArr = s.toCharArray();
        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];
        Arrays.fill(firstOcc, Integer.MAX_VALUE);
        Arrays.fill(lastOcc, -1);
        for (int i = 0; i < n; i++) {
            firstOcc[chArr[i] - 'a'] = Math.min(firstOcc[chArr[i] - 'a'], i);
            lastOcc[chArr[i] - 'a'] = Math.max(lastOcc[chArr[i] - 'a'], i);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (firstOcc[i] < lastOcc[i]) {
                boolean[] visited = new boolean[26];
                for (int j = firstOcc[i] + 1; j < lastOcc[i]; j++) {
                    if (!visited[chArr[j] - 'a']) {
                        visited[chArr[j] - 'a'] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
```