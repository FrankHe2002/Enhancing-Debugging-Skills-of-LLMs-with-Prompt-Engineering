Bug Type: Infinite Loop

Reasoning: The loop condition `i >= s.length()` should be `i < s.length()`. The current condition causes the loop to never terminate since `i` is always greater than or equal to the length of the string `s`. This leads to an infinite loop.

Fix:

```java
// Runtime: 1 ms (Top 95.10%) | Memory: 37.2 MB (Top 97.18%)

class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> lr = new ArrayList<>();

        HashMap<Character, Boolean> mp = new HashMap<>();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (! mp.containsKey(s.charAt(i)) && s.lastIndexOf(Character.toString(s.charAt(i))) != i) {
                mp.put(s.charAt(i), true);
            } else if (mp.containsKey(s.charAt(i)) && s.lastIndexOf(Character.toString(s.charAt(i))) == i) {
                mp.remove(s.charAt(i));
            }

            if (mp.isEmpty()) {
                lr.add(count + 1);
                count = 0;
            } else {
                count++;
            }
        }

        return lr;
    }
}
```