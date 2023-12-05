```java
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {

        int[] fre = new int[26];
        String ans = "";

        for (char c : s.toCharArray())
            fre[c - 'a'] += 1;

        for (String s1 : dictionary) {
            int idx1 = 0, idx2 = 0;

            while (idx1 < s1.length() && idx2 < s.length()) {
                if (s1.charAt(idx1) == s.charAt(idx2)) {
                    idx1++;
                }
                idx2++;
            }

            if (idx1 == s1.length()) {
                if (s1.length() > ans.length() || (s1.length() == ans.length() && s1.compareTo(ans) < 0)) {
                    ans = s1;
                }
            }
        }

        return ans;
    }
}
```