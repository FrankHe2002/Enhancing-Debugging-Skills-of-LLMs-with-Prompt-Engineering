```java
class Solution {
    String ans;

    public String crackSafe(int n, int k) {
        int minLen = (int) Math.pow(k, n) + (n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        String start = sb.toString();
        dfs(start, n, k, new HashSet<String>(), minLen);
        return ans;
    }

    private void dfs(String s, int n, int k, HashSet<String> visited, int minLen) {
        if (s.length() == minLen) {
            ans = s;
            return;
        }
        if (s.length() > minLen) {
            return;
        }

        for (int i = 0; i < k; i++) {
            String next = s + i;
            String lastN = next.substring(next.length() - n);
            if (!visited.contains(lastN)) {
                visited.add(lastN);
                dfs(next, n, k, visited, minLen);
                if (ans.length() != minLen) {
                    visited.remove(lastN);
                } else {
                    return;
                }
            }
        }

    }
}
```