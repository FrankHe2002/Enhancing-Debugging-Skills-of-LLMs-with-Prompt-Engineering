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
            String temp = s + String.valueOf(i);
            String lastN = temp.substring(Math.max(0, temp.length() - n), temp.length());
            if (visited.contains(lastN)) {
                continue;
            }
            if (lastN.length() == n) {
                visited.add(lastN);
            }

            dfs(temp, n, k, visited, minLen);
            if (visited.size() != minLen - n + 1) {
                return;
            }
            visited.remove(lastN);
        }

    }
}