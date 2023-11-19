```java
class Solution {
    public int minSteps(String s, String t) {
        int sf[] = new int[26];
        int tf[] = new int[26];
        int diff = 0; // fix 1: change diff value to 0
        for (char c : s.toCharArray()) {
            sf[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tf[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            diff += (int) Math.abs(sf[i] - tf[i]);
        }
        return diff / 2;
    }
}
```