Bug type: Infinite recursion

Reasoning process:
1. The code uses a depth-first search (DFS) algorithm to generate a password.
2. The DFS is implemented recursively, with the `dfs` method calling itself.
3. The base case for the recursion is when `s.length()` is equal to `minLen`.
4. The recursive call is made at the end of the loop, after removing the last character from `s`.

The bug is caused by the incorrect placement of the recursive call and the removal of the last character of `s`. Since the recursive call is made after modifying `s`, it causes an infinite recursion for certain inputs.

For example, consider the case where `n = 1` and `k = 2`. The `dfs` method will generate the following sequence:

- "0" (initial state)
- "00" (recursive call)
- "01" (recursive call)
- "011" (recursive call)
- "0111" (recursive call)
- "01110" (recursive call)
- ...

The method keeps adding "1" to the string but never terminates.

Fix:
- Move the recursive call before modifying `s` and remove the last character only if it is not already in the visited set.

Updated code with minimal change:
```java
// Runtime: 91 ms (Top 5.23%) | Memory: 0.1 MB (Top 5.06%)

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
            // If already in hashset, rollback and continue;
            if (visited.contains(lastN)) {
                continue;
            }
            if (lastN.length() == n) { // only put n length string in hashset
                visited