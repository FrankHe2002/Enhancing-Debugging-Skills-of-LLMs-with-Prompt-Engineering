```java
// Runtime: 91 ms (Top 5.23%) | Memory: 0.1 MB (Top 5.06%)

class Solution {
    String ans;

    public String crackSafe(int n, int k) {
        int minLen = (int) Math.pow(k, n) + (n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        String start = sb.toString();
        dfs(start, n, k, new HashSet<String>(), minLen);
        return ans;
    }

    private void dfs(String s, int n, int k, HashSet<String> visited, int minLen) {
        if (ans != null) {
            return;
        }
        if (s.length() == minLen) {
            ans = s;
            return;
        }
        
        for (int i = 0; i < k; i++) {
            String newStr = s + i;
            String lastN = newStr.substring(newStr.length() - n);
            if (visited.contains(lastN)) {
                continue;
            }
            visited.add(lastN);
            dfs(newStr, n, k, visited, minLen);
            visited.remove(lastN);
        }
    }
}
```