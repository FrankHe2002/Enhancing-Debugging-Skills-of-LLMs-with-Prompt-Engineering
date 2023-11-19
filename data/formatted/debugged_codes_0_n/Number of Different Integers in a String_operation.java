```java
// Runtime: 2 ms (Top 75.97%) | Memory: 37.1 MB (Top 64.92%)
class Solution {
    public int numDifferentIntegers(String word) {
        String[] arr = word.replaceAll("[^0-9]", " ").split("\\s+");
        Set<String> set = new HashSet<String>();

        for (String str : arr) {
            if (! str.isEmpty())
                set.add(String.valueOf(str.replaceAll("^0*", "")));
        }

        return set.size();
    }
}
```