```java
// Runtime: 0 ms (Top 100%) | Memory: 36.7 MB (Top 99.87%)
class Solution {
    public int maxLength(List<String> arr) {
        List<String> words = arr.stream().filter(o -> o.chars().distinct().count() == o.length()).collect(Collectors.toList());
        int[] dp = new int[1 << words.size()];
        int[] ok = new int[1 << words.size()];
        for (int i = 0; i < words.size(); i++) {
            for (char ch : words.get(i).toCharArray()) {
                ok[1 << i] |= 1 << (ch - 'a');
                dp[1 << i]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if ((ok[i & (i - 1)] & ok[i & - i]) == 0) {
                dp[i] = dp[i & (i - 1)] + dp[i & - i];
                ok[i] = ok[i & (i - 1)] | ok[i & - i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
```