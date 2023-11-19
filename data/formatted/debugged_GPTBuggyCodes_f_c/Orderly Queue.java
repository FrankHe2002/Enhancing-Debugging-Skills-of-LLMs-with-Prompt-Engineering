Bug Type: ArrayIndexOutOfBoundsException

Reasoning: In the `orderlyQueue` method, if `k` is equal to 1, the code appends `s.substring(0, n-1)` to `s`, which effectively wraps the string around itself. However, when evaluating the substring `s.substring(i, i + n)` in the nested for loop, it causes an `ArrayIndexOutOfBoundsException` because the ending index `i + n` goes beyond the length of the string `s`. Since `n` represents the length of the original string `s` before the wrapping, the maximum valid index for the substring should be `i + n - 1`.

Fix:
```java
// Time O(n)
// Space O(n)
class Solution {
    public String orderlyQueue(String s, int k) {
        int n = s.length();
        String ans = "";
        if (k == 1) {
            s += s.substring(0, n-1); // add itself without the last character
            for (int i = 0; i < n; i++)
                if (ans.isEmpty() || s.substring(i, i + n - 1).compareTo(ans) < 0) {
                    ans = s.substring(i, i + n - 1);
                }
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            ans = String.valueOf(arr);
        }
        return ans;
    }
}
```