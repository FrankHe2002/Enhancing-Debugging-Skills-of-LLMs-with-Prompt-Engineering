Fixed Code:
```java
// Runtime: 7 ms (Top 50.47%) | Memory: 39.3 MB (Top 72.86%)
class Solution {
    public int numDifferentIntegers(String word) {
        String[] arr = word.replaceAll("[^0-9]", " ").split("\\s+");
        Set<String> set = new HashSet<String>();

        for (String str : arr) {
            if (!str.isEmpty())
                set.add(String.valueOf(str.replaceAll("^0*", "")));
        }

        return set.size();
    }
}
```