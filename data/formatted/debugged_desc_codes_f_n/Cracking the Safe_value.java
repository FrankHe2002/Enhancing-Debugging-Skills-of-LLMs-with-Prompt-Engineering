```java
// Runtime: 7 ms (Top 16.52%) | Memory: 41.7 MB (Top 10.79%)

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
            String nextSequence = s + i;
            String lastN = nextSequence.substring(Math.max(0, nextSequence.length() - n), nextSequence.length());
            //If already in hashset, rollback and continue;
            if (visited.contains(lastN)) {
                continue;
            }
            if (lastN.length() == n) { // only put n length string in hashset
                visited.add(lastN);
            }
            dfs(nextSequence, n, k, visited, minLen);
            if (ans != null) {
                return; // found answer, no need to continue
            }
            visited.remove(lastN);
        }
    }
}
```