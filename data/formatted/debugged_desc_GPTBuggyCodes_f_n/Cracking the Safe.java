```java
class Solution {
    String ans;

    public String crackSafe(int n, int k) {
        int minLen = (int) Math.pow(k, n) + (n - 1);

        dfs("", n, k, new HashSet<String>(), minLen);
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
            String next = s + String.valueOf(i);
            String lastN = next.substring(Math.max(0, next.length() - n), next.length());
            if (visited.contains(lastN)) {
                continue;
            }
            
            visited.add(lastN);

            dfs(next, n, k, visited, minLen);

            if (ans.length() == minLen) {
                return;
            }

            visited.remove(lastN);
        }
    }
}
```