```java
class Solution {
    int max = 0;

    public int maxUniqueSplit(String s) {
        int n = s.length();
        Set<String> set = new HashSet<String>();
        backtrack(s, 0, set);
        return max;
    }

    public void backtrack(String s, int start, Set<String> h) {
        if (start == s.length()) {
            max = Math.max(max, h.size());
        }
        String res = "";

        for (int i = start; i < s.length(); i++) {
            res += s.charAt(i);
            if (h.contains(res)) continue;
            Set<String> newSet = new HashSet<String>(h);
            newSet.add(res);
            backtrack(s, i + 1, newSet);
        }
    }
}
```