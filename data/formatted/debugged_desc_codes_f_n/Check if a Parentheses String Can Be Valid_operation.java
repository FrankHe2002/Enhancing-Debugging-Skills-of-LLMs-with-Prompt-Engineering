```java
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        int possibleOpens = 0;
        int fixedCloses = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                possibleOpens++;
            } else {
                fixedCloses++;
            }

            if (fixedCloses > possibleOpens) return false;
        }

        possibleOpens = 0;
        fixedCloses = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                possibleOpens++;
            } else {
                fixedCloses++;
            }

            if (fixedCloses > possibleOpens) return false;
        }

        return true;
    }
}
```