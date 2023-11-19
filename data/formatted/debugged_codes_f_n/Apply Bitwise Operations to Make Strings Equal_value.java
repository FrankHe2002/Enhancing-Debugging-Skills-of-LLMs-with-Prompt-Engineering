```java
// Runtime: 3 ms (Top 65.0%) | Memory: 44.72 MB (Top 11.1%)

class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {     // if already equal
            return true;
        }
        // if both have 1s, return true, otherwise false
        return countOnes(s) > 0 && countOnes(target) > 0;
    }

    // method to count the number of 1s in the string
    private int countOnes(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }
}

// TC: O(n), SC: O(2)
```