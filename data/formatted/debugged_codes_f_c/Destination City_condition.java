Bug Type: ArrayIndexOutOfBoundsException

Reasoning: The bug occurs in the second loop (line 11) where it uses `<=` in the loop condition, attempting to access an index out of the list's bounds. The loop should iterate from 0 to `paths.size() - 1` (inclusive), which can be achieved by changing the condition to `< paths.size()`.

Fix:
```java
// Runtime: 4 ms (Top 58.98%) | Memory: 44 MB (Top 40.73%)
class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set1 = new HashSet<>();

        for (int i = 0; i < paths.size(); ++ i) {
            set1.add(paths.get(i).get(0));
        }
        for (int i = 0; i < paths.size(); ++ i) {
            if (! set1.contains(paths.get(i).get(1))) return paths.get(i).get(1);
        }
        return "placeholder";
    }
}
```