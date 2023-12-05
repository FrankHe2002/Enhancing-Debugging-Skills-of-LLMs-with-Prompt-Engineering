```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        int start = 0;
        int ans = 0;
        for (int end = 0; end < s.length(); end++) {
            if (hash.containsKey(s.charAt(end))) {
                start = Math.max(start, hash.get(s.charAt(end)) + 1);
            }
            hash.put(s.charAt(end), end);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
```