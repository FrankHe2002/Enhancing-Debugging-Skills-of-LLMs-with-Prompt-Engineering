The bug in the provided code is that the while loop condition in the `digitSum` method is incorrect. The condition should be `s.length() > k` instead of `s.length() <= k` to ensure that the rounds are completed when the length of the updated string `s` is greater than `k`.

Here's the updated code with the fix:

```java
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) s = gen(s, k);  // Fix: change the loop condition to s.length() > k
        return s;
    }

    public String gen(String s, int k) {
        String res = "";
        for (int i = 0; i < s.length(); ) {
            int count = 0, num = 0;
            while (i < s.length() && count++ < k) num += Character.getNumericValue(s.charAt(i++));
            res += num;
        }
        return res;
    }
}
```

With this change, the code now correctly handles the completion of rounds when the length of `s` is greater than `k`.