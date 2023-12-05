```java
// Runtime: 7 ms (Top 96.2%) | Memory: 40.32 MB (Top 56.2%)

class Solution {
    public static boolean isSolvable(String[] words, String result) {
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        result = new StringBuilder(result).reverse().toString();
        if (! checkLength(words, result)) {
            return false;
        }
        boolean[] visited = new boolean[10];    
        int[] chToDigit = new int[26];
        Arrays.fill(chToDigit, - 1);
        return dfs(0, 0, 0, visited, chToDigit, words, result);
    }

    private static boolean checkLength(String[] words, String result) {
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        return result.length() == maxLen || result.length() == maxLen + 1;
    }

    private static boolean dfs(int i, int j, int carrier, boolean[] visited, int[] chToDigit, String[] words, String result) {
        if (i == words.length) {
            char ch = result.charAt(j);
            if (j == result.length() - 1) {
                if (carrier >= 10) {
                    return false;
                }
                if (j > 0 && j == result.length() - 1 && chToDigit[ch - 'A'] != 0) {
                    return false;
                }
                if (chToDigit[ch - 'A'] == - 1) {
                    System.out.println(Arrays.toString(chToDigit));
                    return true;
                } else {
                    return chToDigit[ch - 'A'] == carrier;
                }
            } else {
                if (chToDigit[ch - 'A'] == - 1) {
                    int selectedDigit = carrier % 10;
                    if (visited[selectedDigit]) {
                        return false;
                    }
                    visited[selectedDigit] = true;
                    chToDigit[ch - 'A'] = selectedDigit;
                    if (dfs(0, j + 1, carrier / 10, visited, chToDigit, words, result)) {
                        return true;
                    }
                    chToDigit[ch - 'A'] = - 1;
                    visited[selectedDigit] = false;
                } else {
                    if (chToDigit[ch - 'A'] != carrier % 10) {
                        return false;
                    }
                    boolean ans = dfs(0, j + 1, carrier / 10, visited, chToDigit, words, result);
                    return ans;
                }
            }
        } else {
            String word = words[i];
            if (j >= word.length()) {
                boolean ans = dfs(i + 1, j, carrier, visited, chToDigit, words, result);
                return ans;
            }
            if (j == word.length() - 1 && word.length() > 1 && chToDigit[word.charAt(j) - 'A'] == 0) {
                return false;
            }
            char ch = word.charAt(j);
            if (chToDigit[ch - 'A'] != - 1) {
                int newSum = carrier + chToDigit[ch - 'A'];
                boolean ans = dfs(i + 1, j, newSum, visited, chToDigit, words, result);
                return ans;
            } else {
                for (int k = 0; k < visited.length; k++) {
                    if (visited[k]) {
                        continue;
                    }
                    visited[k] = true;
                    chToDigit[ch - 'A'] = k;
                    int newSum = k + carrier;
                    boolean ans = dfs(i + 1, j, newSum, visited, chToDigit, words, result);
                    if (ans) {
                        return true;
                    }
                    visited[k] = false;
                    chToDigit[ch - 'A'] = - 1;
                }
            }
        }
        return false;
    }
}
```