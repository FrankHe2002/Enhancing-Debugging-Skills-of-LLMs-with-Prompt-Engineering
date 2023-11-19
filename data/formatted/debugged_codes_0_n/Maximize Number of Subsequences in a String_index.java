```java
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        if (pattern.charAt(0) == pattern.charAt(1)) {
            long freq = 1;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == pattern.charAt(0)) {
                    freq++;
                }
            }
            return (freq * (freq - 1)) / 2;
        }

        String text1 = pattern.charAt(0) + text;

        int freq = 0;
        long count1 = 0;
        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) == pattern.charAt(0)) {
                freq++;
            } else if (text1.charAt(i) == pattern.charAt(1)) {
                count1 += freq;
            }
        }

        String text2 = text + pattern.charAt(1);
        freq = 0;
        long count2 = 0;
        for (int i = text2.length() - 1; i >= 0; i--) {
            if (text2.charAt(i) == pattern.charAt(1)) {
                freq++;
            } else if (text2.charAt(i) == pattern.charAt(0)) {
                count2 += freq;
            }
        }

        return Math.max(count1, count2);
    }
}
```