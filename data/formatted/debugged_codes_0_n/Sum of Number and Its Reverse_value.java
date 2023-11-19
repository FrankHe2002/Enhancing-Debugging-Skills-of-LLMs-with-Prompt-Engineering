```java
// Runtime: 34 ms (Top 98.4%) | Memory: 43.48 MB (Top 20.6%)

class Solution {
    static HashSet<Integer> set = new HashSet<>(); // Unchanged

    static {
        for (int i = 0; i <= 100000; i++) { // Unchanged
            set.add(i + Integer.parseInt(new StringBuilder(Integer.toString(i)).reverse().toString()));
        }
    }

    public boolean sumOfNumberAndReverse(int num) { // Unchanged
        return set.contains(num);
    }
}
```