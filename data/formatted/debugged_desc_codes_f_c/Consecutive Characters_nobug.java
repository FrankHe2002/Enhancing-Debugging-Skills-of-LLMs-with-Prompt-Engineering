```java
class Solution {
    public int maxPower(String s) {
        int maxConsecutive = 1; // 1 is init value because otherwise the compared char itself is not counted
        int counterConsecutive = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                counterConsecutive++;
                maxConsecutive = Math.max(counterConsecutive, maxConsecutive);
            } else {
                counterConsecutive = 1;
            }
        }
        
        // Check the last character of the string
        if (s.length() > 1 && s.charAt(s.length() - 1) == s.charAt(s.length() - 2)) {
            counterConsecutive++;
            maxConsecutive = Math.max(counterConsecutive, maxConsecutive);
        }
        
        return maxConsecutive;
    }
}
```