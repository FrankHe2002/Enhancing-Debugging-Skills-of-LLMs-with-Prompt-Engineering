```java
class Solution {
    public int numSplits(String s) {
        int a[] = new int[26];
        int b[] = new int[26];
        int ds1 = 0, ds2 = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            b[s.charAt(i) - 'a']++;
            if (b[s.charAt(i) - 'a'] == 1)
                ds2++;
        }
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            b[s.charAt(i) - 'a']--;
            if (b[s.charAt(i) - 'a'] == 0)
                ds2--;
            if (a[s.charAt(i) - 'a'] == 1)
                ds1++;
            if (ds1 == ds2)
                count++;
        }
        return count;
    }
}
```

The changes made:
1. Replaced `97` with `'a'` to convert the ASCII value of `a` to its character representation.