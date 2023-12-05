Fix:
```java
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[1000];

        for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

        int val = freq[s.charAt(0) - 'a'];
        for (int i = 0; i < 1000; i++)
            if (freq[i] != 0 && freq[i] != val) return false;

        return true;
    }
}
```