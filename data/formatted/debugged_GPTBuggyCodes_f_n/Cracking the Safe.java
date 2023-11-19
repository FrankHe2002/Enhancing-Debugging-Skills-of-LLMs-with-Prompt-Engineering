```java
// Runtime: 91 ms (Top 5.23%) | Memory: 124.1 MB (Top 5.06%)

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
            String newS = s + i;
            String lastN = newS.substring(Math.max(0, newS.length() - n), newS.length());
            if (visited.contains(lastN)) {
                continue;
            }
            if (lastN.length() == n) {
                visited.add(lastN);
            }

            dfs(newS, n, k, visited, minLen);
            if (visited.size() == minLen - n + 1) {
                return;
            }
            visited.remove(lastN);
        }
    }
}
```