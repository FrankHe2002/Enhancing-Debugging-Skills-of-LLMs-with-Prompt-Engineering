Fix:
```java
class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int zeroToOne = 0;
        int countOfOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0')
                zeroToOne += 1;
            else
                countOfOnes = Math.min(zeroToOne, countOfOnes + 1);
        }
        return Math.min(zeroToOne, countOfOnes);
    }
}
```