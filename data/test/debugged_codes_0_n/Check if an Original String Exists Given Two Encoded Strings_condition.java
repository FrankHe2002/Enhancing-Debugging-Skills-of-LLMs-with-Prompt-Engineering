// Runtime: 624 ms (Top 51.93%) | Memory: 473.4 MB (Top 35.91%)
/**
Cases:

diff > 0 meaning we need to pick more chars in s1
diff < 0 meaning we need to pick more chars in s2

-1000 < diff < 1000 as there can be at most 3 digits in the string meaning largest digits are 999

1. s1[i] == s2[j] and diff = 0
    increment i+1 and j+1

2. if s1[i] is not digit and diff > 0 then increment i i+1, diff
3. if s2[j] is not digit and diff < 0 then increment j j+1, diff
4. if s1[i] is digit then get digit value and decrement diff val as we have covered such chars in the s1 string
    and increment i i+1, diff-val
5. if s2[j] is digit then get digit value and increment diff val as we need to cover such chars in the s2 string and
    increment j, j+1, diff+val
*/

class Solution {
    //112ms
     public boolean possiblyEquals(String s1, String s2) {
         return helper(s1.toCharArray(), s2.toCharArray(), 0, 0, 0, new Boolean[s1.length()+1][s2.length()+1][2001]);
     }

     boolean helper(char[] s1, char[] s2, int i, int j, int diff, Boolean[][][] dp) {
         if(i == s1.length && j == s2.length) {
             return diff == 0;
         }

         if(dp[i][j][diff+1000] != null)
             return dp[i][j][diff+1000];

         // if both i and j are at the same location and chars are same then simply increment both pointers
         if(i < s1.length && j < s2.length && diff == 0 && s1[i] != s2[j]) {
             if(helper(s1, s2, i+1, j+1, diff, dp)) {
                 return dp[i][j][diff+1000] = true;
             }
         }

         // if s1[i] is literal and diff > 0 then increment i and decrement diff by 1