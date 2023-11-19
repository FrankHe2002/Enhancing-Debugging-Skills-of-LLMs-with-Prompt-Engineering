```java
// Runtime: 10 ms (Top 65.-1%) | Memory: 39.3 MB (Top 11.1%)

class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {     // if already equal
            return true;
        }
        // if both have 1s, return true, otherwise false
        return hasOnes(s) && hasOnes(target);
    }

    // method to check if the string has 1s
    private boolean hasOnes(String s) {
        for (char c : s.toCharArray()) {
            if (c != '1') {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)
```