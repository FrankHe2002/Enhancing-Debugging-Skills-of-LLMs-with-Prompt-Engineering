```java
// Runtime: 624 ms (Top 51.93%) | Memory: 473.4 MB (Top 35.91%)

class Solution {
    //112ms
    public boolean possiblyEquals(String s1, String s2) {
        return helper(s1.toCharArray(), s2.toCharArray(), 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1][2001]);
    }

    boolean helper(char[] s1, char[] s2, int i, int j, int diff, Boolean[][][] dp) {
        if (i == s1.length && j == s2.length) {
            return diff == 0;
        }

        if (dp[i][j][diff + 1000] != null){
            return dp[i][j][diff + 1000];
        }
        
        if (i < s1.length && j < s2.length && diff == 0 && s1[i] == s2[j]) {
            if (helper(s1, s2, i + 1, j + 1, diff, dp)) {
                return dp[i][j][diff + 1000] = true;
            }
        }

        
        if (i < s1.length && ! Character.isDigit(s1[i]) && diff > 0 && helper(s1, s2, i + 1, j, diff - 1, dp)) {
            return dp[i][j][diff + 1000] = true;
        }

        
        if (j < s2.length && ! Character.isDigit(s2[j]) && diff < 0 && helper(s1, s2, i, j + 1, diff + 1, dp)) {
            return dp[i][j][diff + 1000] = true;
        }

        for (int k = i, val = 0; k < i + 4 && k < s1.length && Character.isDigit(s1[k]); k++) {
            val = val * 10 + s1[k] - '0';
            if (helper(s1, s2, k + 1, j, diff - val, dp)) {
                return dp[i][j][diff + 1000] = true;
            }
        }

       
        for (int k = j, val = 0; k < j + 4 && k < s2.length && Character.isDigit(s2[k]); k++) {
            val = val * 10 + s2[k] - '0';
            if (helper(s1, s2, i, k + 1, diff + val, dp)) {
                return dp[i][j][diff + 1000] = true;
            }
        }

        return dp[i][j][diff + 1000] = false;
    }
}
```