```java
class Solution {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        long count = 0;

        long[] freq = new long[(1 << 10)];

        freq[0] = 1;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int mask = (1 << (word.charAt(i) - 'a'));
            res ^= mask;
            int chkMask = 1;

            count += freq[res];
            for (int j = 1; j <= 10; j++) {
                count += freq[chkMask ^ res];
                chkMask <<= 1;
            }

            freq[res]++;
        }

        return count;
    }
}
```