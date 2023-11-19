```java
class Solution {
    public int maxPower(String s) {
        int maxConsecutive = 1;
        int counterConsecutive = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                counterConsecutive++;
                maxConsecutive = Math.max(counterConsecutive, maxConsecutive);
            } else {
                counterConsecutive = 1;
            }
        }
        return maxConsecutive;
    }
}
```